node {
  try {
    stage("Echo Stage"){
      timestamps {
        cleanWs()
        sh """echo 'Hello World. This is [Echo Stage] of pipeline job' """
      }
    }
  } catch(err) {
    println err
  }
}
