// This file is written by -> creating a pipeline job manually -> populating the pipeline script block with sample pipeline script -> 
// improvising it -> copying the content here ...

node {
  try {
    stage("Echo Stage"){
      timestamps {
        cleanWs()
        if (isUnix()) {
          sh """echo 'Hello World. This is [Echo Stage] of pipeline job' """
        } else {
          bat """echo 'Hello World. This is [Echo Stage] of pipeline job' """
        }
      }
    }
    stage("Checkout Stage"){
      timestamps {
        cleanWs()
        git credentialsId: 'arghyaGithubId', url: 'https://github.com/ArghyaChakraborty/demo-java.git'
      }
    }
   stage('Build Stage') {
      mvnHome = tool 'Local-Maven'
      // Run the maven build
      withEnv(["MVN_HOME=$mvnHome"]) {
         if (isUnix()) {
            jobStatus = sh(returnStatus: true, script: '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package')
         } else {
            jobStatus = bat(returnStatus: true, script : /"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
         }
      }
   }
  } catch(err) {
    println err
  }
}
