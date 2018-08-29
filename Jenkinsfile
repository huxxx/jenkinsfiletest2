pipeline {
    agent any
    stages {
		stage("checkout"){
			steps {
				git branch: '${BRANCH_NAME}', credentialsId: '5f2507246ebe2e1345d8455ab288f7bdcfeb83cd', url: 'git@github.com:huxxx/jenkinsfiletest2.git'
			}
		}
		stage('Build') {
            steps {
				sh "sudo mvn clean install deploy"
            }
        }
        stage('Test') {
            steps {
                sh 'echo "Fail!"; exit 1'
            }
        }
    }
    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}
