def ip_address
pipeline {
    agent any
    stages {
        stage('git'){
            steps {
                git 'https://github.com/rishabh-28/SpringApplication.git'
            }
        }
        stage('Mavenn'){
            steps {
                withMaven(maven:'mvn3'){
                    sh 'mvn clean'
                    sh 'mvn compile'
                    sh 'mvn package'
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withMaven(maven:'mvn3'){
                    withSonarQubeEnv('sonar') { 
                        sh "$MAVEN_HOME/bin/mvn sonar:sonar"
                    }
                }
            }
        }
        stage('build docker image'){
            steps {
                sh 'docker build -t rrishabhbansal96/spring:1.0.0 .'
            }
        }
        stage('Push docker image') {
            steps {
                withCredentials([string(credentialsId: 'docker-user', variable: 'dockerPwd')]){
                    sh "docker login -u rrishabhbansal96 -p ${dockerPwd}"
                }
                sh 'docker push rrishabhbansal96/spring:1.0.0'
            }
        }
        stage('AWS'){
            steps {
                withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'aws-user', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
                    sh 'ansible-playbook create-ec2.yml'
                }
            }
        }
        
        stage('Capture IP address') {
            steps {
                    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'aws-user', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
                        script{
                            def get_ip='aws ec2 describe-instances --filters "Name=tag:Name,Values=ansible"  --query "Reservations[*].Instances[*].PublicIpAddress" --output text --region us-west-2'
                            def output = sh script :"${get_ip}",returnStdout:true
                            ip_address = output
                        }
                    }
            }
        }
		
        stage('Install Docker'){
            steps {
                script{
                    print ip_address
                    def dockerCMD = 'sudo yum install -y docker; sudo systemctl start docker; sudo systemctl enable docker; sudo chmod 777 /var/run/docker.sock'
                    sshagent(credentials: ['ssh-key']) {
                    sh "ssh -tt -o StrictHostKeyChecking=no ec2-user@${ip_address} ${dockerCMD}"
                    }
                }
            }
        }
        stage('Pull Docker Container'){
            steps {
                script{
                    print ip_address
                    def dockerCMD = 'sudo docker pull rrishabhbansal96/spring:1.0.0'
                    sshagent(credentials: ['ssh-key']) {
						sh "ssh -tt -o StrictHostKeyChecking=no ec2-user@${ip_address} ${dockerCMD}"
                    }
                }
            }
        }
		
        stage('Run Docker Container'){
            steps {
                script{
                    print ip_address
                    def dockerCMD = 'sudo docker run -d rrishabhbansal96/spring:1.0.0'
                    sshagent(credentials: ['ssh-key']) {
						sh "ssh -tt -o StrictHostKeyChecking=no ec2-user@${ip_address} ${dockerCMD}"
                    }
                }
            }
        }
		
		
    }
    post {
        always {
            echo 'One way or another, I have finished'
            deleteDir() /* clean up our workspace */
			mail to: 'rrishabhbansal96@gmail.com', from: 'mywebsite2810@gmail.com', subject: "Complete Pipeline: ${currentBuild.fullDisplayName}", body: "Something is wrong with ${env.BUILD_URL}"
        }
		failure {
		    echo 'Failure!'
			mail to: 'rrishabhbansal96@gmail.com', from: 'mywebsite2810@gmail.com', subject: "Failed Pipeline: ${currentBuild.fullDisplayName}", body: "Something is wrong with ${env.BUILD_URL}"
		}
    }
}
