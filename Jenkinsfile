CODE_CHANGES = getGitChanges()
pipeline {
    agent any
    parameters {
        //string(name: 'VERSION', defaultValue: '', description: 'version to deploy on product')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    tools {
        maven 'Maven' //'Maven' is the name of maven, which is pre-configured and pre-installed in Jenkins "Global tool configuration" interface
    }
    stages {
        stage("build"){
            steps{
                sh "mvn -version" // now mvn command is available in this whole file
            }
        }

        stage("test"){
            when {
                expression {
                    params.executeTests // or  params.executeTests == true
                }
            }
            steps{
                echo 'testing the application...'
            }
        }

        stage("deploy"){
            steps{
                echo "deploying version ${params.VERSION}"
                echo 'deploying the application...'
            }
        }
    }
}
