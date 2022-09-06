// pipeline {
//     agent any
//     tools{
//         maven 'maven_3.8.6'
//     }
    node('linux'){
            stage('Checkout from github'){


                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [],
                     userRemoteConfigs: [[url: 'https://github.com/surajmishra99/medtalk.git']]])
               echo "checkout success"
                }


            stage('Build mvn project'){
                def buildInfo

                    script{

//                         bat 'mvn clean package'
  {
        buildInfo = rtMaven.run pom:'pom.xml',goals : 'clean package'}
        echo "build success : ${buildInfo}"

                    }
                }
            }





//         stage('maven build')
//         {
//         buildInfo = rtMaven.run pom:'pom.xml',goals : 'clean package'}
//         echo "build success : ${buildInfo}"
//     }
// }


// def getBaseVersion(){
//                 return sh(script: "mvn org.apache.maven.plugins:maven-help-plugin:3.1.0:evaluate -Dexpression=project.version
//                 -q -DforceStdout",returnStdout: true)
//                 .replace('-SNAPSHOT','')
//                 .replace('-RELEASE','')