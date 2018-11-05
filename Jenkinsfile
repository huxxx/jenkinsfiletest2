def label = "mavendocker-${UUID.randomUUID().toString()}"
agent {
    node {
        label ${label}
        tools {
	        //工具名称必须在Jenkins 管理Jenkins → 全局工具配置中预配置。
	        maven 'apache-maven-3.5.4'
    	}
    	stage('checkout') {
      		git branch: '${BRANCH_NAME}', credentialsId: 'a7807ca4-de23-4d80-b1eb-82ce5d952064', url: 'https://github.com/huxxx/jenkinsfiletest2.git'
   		}
   		stage('maven-build') {
   		  sh 'mvn --version'
		  // Run the maven build sh 'mvn -B -U clean package deploy -Dmaven.test.skip=true -Pdocker'
	      if (isUnix()) {
	         sh "'${mvnHome}/bin/mvn' -Dmaven.test.skip=true clean package install "
	      } else {
	         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.skip=true clean package install /)
	      }
	    }
    	stage('clean'){
	   	  // sh 'docker rm -f $(docker ps -a |  grep "myweb-*"  | awk '{print $1}') || true'
		  sh 'docker rmi $(docker images 192.168.232.136:5000/mavendockerplugindemo -q)  || true'
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
	    post {
	        always {
	            echo 'I will always say goodbye again!'
	        }
    	}
    }
}