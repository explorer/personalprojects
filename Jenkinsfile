def filePath = "version.txt"

pipeline {
    agent any
    
    environment {
        tag = VersionNumber(versionNumberString: '1.0.0.${BUILDS_ALL_TIME}');
    }
    
    stages {
        stage('versioning') {
            steps {
                //cleanWs() // Clean workspace before build
                sh "git checkout dev"
                script{
                    if (fileExists(filePath)) {
                        echo 'File exists'
                        fileContents = readFile encoding: 'UTF-8', file: filePath
                        println fileContents
                        writeFile file: "version.txt", text: "$fileContents Version=$env.tag\n"
                        writeFile file: "version.txt", text: "$fileContents\n$env.tag"
                        sh 'ls -l version.txt'
                        sh 'cat version.txt' 
                    } else {
                        echo 'Creating file...'
                        fileOperations([fileCreateOperation(fileContent: '1.111', fileName: 'testdsl.txt')])  //def filePath = "C:\\JenkinsSlave\\lastSuccessfull\\folder\\lastSuccess.txt"
                        writeFile file: 'version.txt', text: env.tag
                        sh 'ls -l version.txt'
                        sh 'cat version.txt'
                    }
                }
                
                // fileOperations([fileCreateOperation(fileContent: '1.111', fileName: 'testdsl.txt')])  //def filePath = "C:\\JenkinsSlave\\lastSuccessfull\\folder\\lastSuccess.txt"
                // writeFile file: 'version.txt', text: env.tag
                // sh 'ls -l version.txt'
                // sh 'cat version.txt'
                // script {
                //     fileContents = readFile encoding: 'UTF-8', file: filePath
                //     println fileContents
                //     writeFile file: "version.txt", text: "$fileContents Version=$env.tag\n"
                //     writeFile file: "version.txt", text: "$fileContents\n$env.tag"
                //     sh 'ls -l version.txt'
                //     sh 'cat version.txt'
                    //env.verPrefix='1.0.0'
                    //env.BUILDS_ALL_TIME = 1
                    //def versionNumber = VersionNumber versionNumberString:'${verPrefix}.${BUILD_MONTH,XX}${BUILD_DAY,XX}-${BUILDS_ALL_TIME}', versionPrefix: ''
                    //echo "VersionNumber: ${versionNumber}"
                    //currentBuild.displayName = versionNumber
                //}
            }
        }    
    }
    
    post{
        success {
            
                script {
                    sh '''
                        git add version.txt
                        git commit -m "Updated version number"
                        git config --global user.email "yaowen.wu@ericsson.com"
                        git config --global user.name "yaowen"
                        '''
                }
            
        }    
    }
    
}
