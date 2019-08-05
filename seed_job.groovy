pipelineJob('ArghyaTestPipelineJob') {
    definition {
        cps {
			      sandbox()
            script(readFileFromWorkspace('arghya_test_pipeline_definition.groovy'))
        }
    }
}
