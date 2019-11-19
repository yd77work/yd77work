properties([pipelineTriggers([cron('*/5 * * * *')])])
node {
    stage('stage01') 
    {
        sh"uptime"
        deleteDir()
     }
    stage("github")
    {
    withCredentials([usernamePassword(credentialsId: '9c3062a2-17a2-4617-a332-6cff68b12cea', passwordVariable: 'password', usernameVariable: 'username')]) 
    {sh"git clone https://$username:$password@github.com/yd77work/Ansible"
    }
    }
    stage("stage02")
    {
        def workDir = sh(returnStdout: true, script: "pwd").trim()
        sh "cd $workDir && cd ./Ansible && ls -lh"
    }
    stage("stage03")
    {
        archiveArtifacts artifacts: "https://github.com/yd77work/Ansible/tree/master/ansible/*.yml", fingerprint: true
     }
}
