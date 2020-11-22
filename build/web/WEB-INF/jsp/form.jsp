<%-- 
    Document   : form
    Created on : 13/06/2019, 06:29:55
    Author     : MAICON
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                
                //envento acionado quando o foco sair do campo cep
                $("#cep").blur(function () {
                    console.log('cep='+ $("#cep").val());
                    //fazendo uma requisição ajax
                    $.ajax({
                        method: "get",
                        url: '<c:url value="/buscar" />',
                        data: 'cep='+$("#cep").val(),
                        success: function (endereco) {
                            console.log(endereco);
                            $('#rua').val(endereco.rua);
                            $('#bairro').val(endereco.bairro);
                            $('#cidade').val(endereco.cidade);
                            $('#uf').val(endereco.bairro);
                        }
                    });
                });

            });

        </script>
    </head>
    <body>
        <form action="cadastrar" >
            <label>CEP</label>
            <input type="text" name="cep" value="" id="cep"/> 

            <br><br>
            <label>Rua</label>
            <input type="text" name="rua" value="" id="rua"/>

            <br><br>
            <label>Bairro</label>
            <input type="text" name="bairro" value="" id="bairro"/>

            <br><br>
            <label>Cidade</label>
            <input type="text" name="cidade" value="" id="cidade"/>    

            <br><br>
            <label>UF</label>
            <select id="uf" name="uf">
                <option value="AC">AC</option>
                <option value="AL">AL</option>
                <option value="AP">AP</option>
                <option value="AM">AM</option>
                <option value="BA">BA</option>
                <option value="CE">CE</option>
                <option value="DF">DF</option>
                <option value="ES">ES</option>
                <option value="GO">GO</option>
                <option value="MA">MA</option>
                <option value="MS">MS</option>
                <option value="MT">MT</option>
                <option value="MG">MG</option>
                <option value="PA">PA</option>
                <option value="PB">PB</option>
                <option value="PR">PR</option>
                <option value="PE">PE</option>
                <option value="PI">PI</option>
                <option value="RJ">RJ</option>
                <option value="RN">RN</option>
                <option value="RS">RS</option>
                <option value="RO">RO</option>
                <option value="RR">RR</option>
                <option value="SC">SC</option>
                <option value="SP">SP</option>
                <option value="SE">SE</option>
                <option value="TO">TO</option>
            </select>     

            <br><br>
            <button type="submit">Enviar</button>
        </form>
    </body>
</html>
