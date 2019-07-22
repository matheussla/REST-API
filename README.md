# REST-API

GET: https://rest-api-math.herokuapp.com/contas

GET(by ID): https://rest-api-math.herokuapp.com/contas/"use id"
example: https://rest-api-math.herokuapp.com/contas/5d3511dca339c400041b1811

POST: https://rest-api-math.herokuapp.com/contas
{
    "numero": "613564",
    "agencia": "4251",
    "cpf": "47507133593"
}    
PUT: https://rest-api-math.herokuapp.com/contas/"use id"
example: https://rest-api-math.herokuapp.com/contas/5d3511dca339c400041b1811
{
    "numero": "613564",
    "agencia": "4251",
    "cpf": "47507133593"
}   
DELETE: https://rest-api-math.herokuapp.com/contas/"use id"  
example: https://rest-api-math.herokuapp.com/contas/5d3511dca339c400041b1811

ENDPOINT:
id : String gerado automaticamente ao criar
numero: String -> Somente digitos e no máximo 6 caracteres 
agencia: String -> Somente digitos e no máximo 4 caracteres
cpf: String -> Somente digitos e no máximo 11 caracteres
status: Boolean -> Default ativo
dataCriacao -> LocalDate
dataAtualizacao -> LocalDate
    


    
    
    
