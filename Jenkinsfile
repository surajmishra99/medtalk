// pipeline {
//     agent any
//     tools{
//         maven 'maven_3.8.6'
//     }
    node('linux'){
        stages{
            stage('Checkout from github'){
                steps{

                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/surajmishra99/medtalk.git']]])
                }
            }

            stage('Build mvn project'){
                def buildInfo

                steps{
                    script{

                        bat 'mvn clean package'
                    }
                }
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