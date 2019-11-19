properties([
    pipelineTriggers([
        GenericTrigger(
            causeString: 'Push to master', 
            genericVariables: [[
                defaultValue: '',
                key: 'ref', 
                regexpFilter: '', 
                value: '$.ref'
            ]], 
            printContributedVariables: true, 
            printPostContent: true, 
            regexpFilterExpression: 'master$', 
            regexpFilterText: '$ref', 
            silentResponse: true, 
            token: '71B6B68DFC8C34235B642BE2'
        )
    ])
])

node(){
    stage(){
          sshagent(['uuuuuuuuuuuuu']) {
            sh "git clone -b master git@github.com:/tests.git ."
        }
        
http://35.223.111.195/generic-webhook-trigger/invoke?token=71B6B68DFC8C34235B64    }
    
}      
input("Please approved deploy to.")
node(){
    
}
