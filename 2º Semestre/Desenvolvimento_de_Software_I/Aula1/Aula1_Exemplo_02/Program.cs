using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula1_Exemplo2
{
    class Program
    {
        static void Main(string[] args)
        {   //Inicio Main

            //Declaração de Variaveis
            int a, b, total;

            //Atribuição de Valores
            a = 20;
            b = 10;

            /*Concatenação de valores a serem exibidos na tela
             * Calculo da operação sendo realizado entre parênteses */
            Console.WriteLine(a + " + " + b + " = " + (a + b));
            //Resultado do cálculo da operação sendo atribuido em uma variavel
            total = a - b;
            Console.WriteLine(a + " - " + b + " = " + total);
            Console.WriteLine(a + " * " + b + " = " + (a * b));
            Console.WriteLine(a + " / " + b + " = " + (a/b));
            Console.WriteLine(a + " % " + b + " = " + (a % b));

            Console.ReadKey();//Instrução utilizada para dar uma pausa para visualização
        } //fim Main
    } //fim class
} //fim namespace
