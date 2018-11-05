node {
   def mvnHome = tool 'apache-maven-3.5.4'
   def dockerRepoUrl = "192.168.232.136:5000"
   def dockerImageName = "mavendockerplugindemo"
   def dockerImageTag = "${dockerRepoUrl}/${dockerImageName}:2.0"
   def containerId = $(docker ps -a | grep "myweb-*" | awk '{print $1}')
    
   stage('checkout') {
      git branch: '${BRANCH_NAME}', credentialsId: 'a7807ca4-de23-4d80-b1eb-82ce5d952064', url: 'https://github.com/huxxx/jenkinsfiletest2.git'
   }
   stage('maven-build') {
	  // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.skip=true clean package install "
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.skip=true clean package install /)
      }
   }
   stage('clean'){
   	  // sh 'docker rm -f $(docker ps -a |  grep "myweb-*"  | awk '{print $1}') || true'
	  // sh 'docker rmi $(docker images 192.168.232.136:5000/mavendockerplugindemo -q)  || true'
	  if(${containerId} ！= "") {
	      docker rm -f ${containerId}
		  sleep 3s
	  } else {
	      echo "not exist containerId！"
	  }
   }
   stage('Results') {
      //junit '**/target/surefire-reports/TEST-*.xml'
      //archive 'target/*.jar'
   }
   stage('Move Jar To Workspace') {
      sh "mkdir -p /workspace && mv ./target/${dockerImageName}*.jar /workspace" 
   }
   stage('Deploy Docker Image'){
      // deploy docker image to nexus
      echo "Docker Image Tag Name: ${dockerImageTag}"

      //sh "docker login -u admin -p admin123 ${dockerRepoUrl}"
      //sh "docker tag ${dockerImageName} ${dockerImageTag}"
      //sh "docker push ${dockerImageTag}"
   }
  
}