pipeline {
    agent any
    stages {
		stage('Build') {
            steps {
				container('maven') {
					sh 'id'
					sh 'env'
					sh 'docker info'
					sh 'mvn -B clean package deploy -Dmaven.test.skip=true -Pdocker'
				}
				sh "mvn clean install deploy"	
            }
        }
		stage ('Build') {
			withMaven(
				// Maven installation declared in the Jenkins "Global Tool Configuration"
				maven: 'apache-maven-3.5.4'
				// Maven settings.xml file defined with the Jenkins Config File Provider Plugin
				// Maven settings and global settings can also be defined in Jenkins Global Tools Configuration
				// mavenSettingsConfig: 'my-maven-settings',
				// mavenLocalRepo: '.repository'
				) {
		 
			  // Run the maven build
			  sh "mvn clean install"
		 
			} // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs reports...
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
