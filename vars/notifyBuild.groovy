#!/usr/bin/env groovy

def call(String buildStatus = 'STARTED') {
// build status of null means successful
buildStatus =  buildStatus ?: 'SUCCESSFUL'

// Default values
def colorName = 'RED'
def colorCode = '#FF0000'
def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
def URL = "<a href='${env.BUILD_URL}'>Open</a>""
def summary = "${subject} (${URL})"

// Override default values based on build status
if (buildStatus == 'STARTED') {
  color = 'YELLOW'
  colorCode = '#FFFF00'
} else if (buildStatus == 'SUCCESSFUL') {
  color = 'GREEN'
  colorCode = '#00FF00'
} else {
  color = 'RED'
  colorCode = '#FF0000'
}
slackSend (color: colorCode, message: summary)
}


// def notifyBuild(String buildStatus = 'STARTED') {
//   // build status of null means successful
//   buildStatus =  buildStatus ?: 'SUCCESSFUL'

//   // Default values
//   def colorName = 'RED'
//   def colorCode = '#FF0000'
//   def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
//   def summary = "${subject} (${env.BUILD_URL})"

//   // Override default values based on build status
//   if (buildStatus == 'STARTED') {
//     color = 'YELLOW'
//     colorCode = '#FFFF00'
//   } else if (buildStatus == 'SUCCESSFUL') {
//     color = 'GREEN'
//     colorCode = '#00FF00'
//   } else {
//     color = 'RED'
//     colorCode = '#FF0000'
//   }

//   // Send notifications
//   slackSend (color: colorCode, message: summary)
//   /* Use slackNotifier.groovy from shared library and provide current build result as parameter */
// //   slackNotifier(currentBuild.currentResult)
// //   cleanWs()

// }
