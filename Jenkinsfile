node{
	agent any
	stages{
		stage('git checkout'){
			git credentialsId: 'git-user', url: 'https://github.com/rishabh-28/SpringApplication.git'
		}
		stage('mvn build'){
			def mvnHome = tool name: 'maven3', type: 'maven'
			def mvnCMD = "${mvnHome}/bin/mvn"
			sh "${mvnCMD} package"
		}		
		stage('sonarqube'){
			//sonarqube
		}
		stage('Docker image build'){
			sh 'docker build -t rrishabhbansal96/spring:1.0.0 .'
		}
		//stage('push to docker.io'){
		//	withCredentials([string(credentialsId: 'docker-user', variable: 'docker')]) {
		//		sh "docker login -u rrishabhbansal96 -p $docker"
		//	}
		//	sh 'docker push rrishabhbansal96/spring:1.0.0'
		//}
		//stage('pull from docker.io'){
		//	sh 'docker pull rrishabhbansal96/spring:1.0.0'
		//}
		stage('run container'){
			sh 'docker run -p 8888:8080 -itd rrishabhbansal96/spring:1.0.0'
		}
		stage('ansible'){
			//ansible
		}
		
	}
	post {
        always {
            echo 'One way or another, I have finished'
            deleteDir() /* clean up our workspace */
			//mail to: 'rrishabhbansal96@gmail.com', subject: "Complete Pipeline: ${currentBuild.fullDisplayName}", body: "Something is wrong with ${env.BUILD_URL}"
        }
		failure {
			mail to: 'rrishabhbansal96@gmail.com', subject: "Failed Pipeline: ${currentBuild.fullDisplayName}", body: "Something is wrong with ${env.BUILD_URL}"
		}
    }
}
