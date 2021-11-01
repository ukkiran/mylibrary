def call(){
    node('master'){
    def spec= [:]
        try {
            stage('Specs Checkout') {
                println "checkout stage"
                cleanWs()
                ciFunc.checkoutVarFunc([
                        repo: Repo,
                        branch: Branch
                ])
            }
            stage('Build') {
                println "build stage"
            }
        }
        catch( e){
            println "ERROR in the pipeline: " + e.getMessage()
            throw e
        }
    }
}
