def buildApp() {
    echo 'Building the application'
}

def testApp() {
    echo 'Testing the application'
}

def deployApp() {
    //All environmental variables in Jenkinsfile are available in the groovy script
    echo "deploying version ${params.VERSION}"  
    echo 'deploying the application...'
}
return this  //this is inportant otherwise you can't import this file in Jenkinsfile
