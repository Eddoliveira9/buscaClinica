package com.projeto.buscaclinica.model

class ValidateEmail(){
    private val EMAIL_REGEX =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

    public fun validar(email: String):Boolean
    {
        var isValid = EMAIL_REGEX.toRegex().matches(email)
        return isValid
    }
}
