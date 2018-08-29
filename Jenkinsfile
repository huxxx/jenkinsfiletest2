node {
   def mvnHome
    stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git branch: '${BRANCH_NAME}', credentialsId: 'ce4f3e25-557e-44ac-80bb-abc50c20960b', url: 'https://github.com/huxxx/jenkinsfiletest2.git' 
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'apache-maven-3.5.4'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('Results') {
      //junit '**/target/surefire-reports/TEST-*.xml'
      //archive 'target/*.jar'
   }
}