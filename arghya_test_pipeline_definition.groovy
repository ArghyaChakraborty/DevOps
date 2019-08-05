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
        git credentialsId: 'arghyaGithubId', url: 'https://github.com/ArghyaChakraborty/simple-java-maven-app.git'
      }
    }
  } catch(err) {
    println err
  }
}
