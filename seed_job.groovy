pipelineJob('ArghyaTestPipelineJob') {
description('This pipeline job is for testing')
    definition {
        cps {
			      sandbox()
            script(readFileFromWorkspace('arghya_test_pipeline_definition.groovy'))
        }
    }
}
