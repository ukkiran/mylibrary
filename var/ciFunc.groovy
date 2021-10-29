def checkoutVarFunc(Map specs) {
    println "Printing specs" + specs
    docheckout = new com.org.service.Codecheckout(this, specs)
    docheckout.checkOutFunc(specs)
}
