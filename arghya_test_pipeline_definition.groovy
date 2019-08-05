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
  } catch(err) {
    println err
  }
}
