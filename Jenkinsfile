node {
   def mvnHome
   stage('checkout') {
      git branch: '${BRANCH_NAME}', credentialsId: 'ce4f3e25-557e-44ac-80bb-abc50c20960b', url: 'https://github.com/huxxx/jenkinsfiletest2.git'
   }
   stage('maven-build') {
      mvnHome = tool 'apache-maven-3.5.4'
	  // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean install"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean install/)
      }
   }
   stage('Results') {
      //junit '**/target/surefire-reports/TEST-*.xml'
      //archive 'target/*.jar'
   }
   //stage('docker-image-build') {
      //mvnHome = tool 'apache-maven-3.5.4'
	  // Run the maven build
      //if (isUnix()) {
         //sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean install"
      //} else {
        // bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean install/)
      //}
   //}
   //stage('Build') {
      // Run the maven build
      //if (isUnix()) {
         //sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      //} else {
         //bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      //}
   //}
  
}