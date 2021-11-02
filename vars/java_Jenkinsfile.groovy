def call(){
    node('master'){
        def specs = [:]
        try {
            stage('Specs Checkout'){
                println 'checkout stage'
                cleanWs()
                ciFunc.checkoutVarFunc([
                    repo: Repo,
                    branch: Branch
                ])
                stage('Read GlobalConfig & Specs'){
                    try {
                    println "reading the specs from Specs repository"
                    def specsDir = "."
                    println "specs version" + specsDir
                        if(fileExists(specsDir + "/specs.yaml")){
                        ci_template = readYaml file : specsDir + "/specs.yaml"
                        specs = specs + ci_template
                        println "reading specs file" + specs
                        }

                        println "reading the global config from resources"
                        def request = libraryResource "com/org/service/config.yaml"
                        config = readYaml text: request
                        println "reading config file" + config
                    }
                    catch(Exception e) {
                        println "Error in reading specs file : " + e.getMessage()
                        throw e
                    }
                }
            }
            stage('Build') {
                println 'build stage'
            }
        }
        catch (Exception e) {
            println 'ERROR in the pipeline: ' + e.getMessage()
            throw e
        }
    }
}
