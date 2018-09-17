node {
   def mvnHome

   def dockerImage
   def dockerRepoUrl = "47.100.49.91:5000"
   def dockerImageName = "mavendockerplugindemo"
   def dockerImageTag = "${dockerRepoUrl}/${dockerImageName}:2.0"
    
   stage('checkout') {
      git branch: '${BRANCH_NAME}', credentialsId: 'a7807ca4-de23-4d80-b1eb-82ce5d952064', url: 'https://github.com/huxxx/jenkinsfiletest2.git'
   }
   stage('maven-build') {
      mvnHome = tool 'apache-maven-3.5.4'
	  // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.skip=true clean package install "
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.skip=true clean package install /)
      }
   }
   stage('Results') {
      //junit '**/target/surefire-reports/TEST-*.xml'
      //archive 'target/*.jar'
   }
   stage('Build Docker Image') {
      // build docker image
      sh "mv ./target/mavendockerplugindemo*.jar ./data" 
      //dockerImage = docker.build("jenkinsfiletest2")
   }
   stage('Deploy Docker Image'){
      // deploy docker image to nexus
      echo "Docker Image Tag Name: ${dockerImageTag}"

      //sh "docker login -u admin -p admin123 ${dockerRepoUrl}"
      //sh "docker tag ${dockerImageName} ${dockerImageTag}"
      //sh "docker push ${dockerImageTag}"
   }
  
}