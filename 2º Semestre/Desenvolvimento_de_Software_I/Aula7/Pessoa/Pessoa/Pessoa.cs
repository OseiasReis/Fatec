using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula6_Exemplo1
{
    class Pessoa
    {
            //Atributos da classe
            private string nome;
            private int idade;
            private double altura;
            private string sexo;

            //Construtor sem parâmetros
            public Pessoa()
            {
                this.nome = null;
                this.idade = 0;
                this.altura = 0.0;
                sexo = null;
            }

            //Contrutor com parâmetros
            public Pessoa(string nome, int idade, double altura, char sexo)
            {
                this.nome = nome;
                this.idade = idade;
                this.altura = altura;
                Sexo = sexo.ToString();
            }
            
        //propriedade do campo nome para acesso ao seu conteudo
        public string Nome
        {
            get { return nome; } //retornar o valor armazenado no campo nome.
            set { nome = value; } //Armazena o valor no campo.
        }

        public int Idade
        {
            get { return idade; }
            set { idade = value; }
        }

        public double Altura
        {
            get { return altura; }
            set { altura = value; }
        }

        public string Sexo
        {
            get { return sexo; } //retornar o valor armazenado no campo sexo.
            set { sexo = value.ToUpper()=="M" ? "MASCULINO": "FEMININO"; }
        }

        //Método para calcular o peso ideal de um pessoa
        public double calcularPesoIdeal()
        {
            if (sexo.Equals("MASCULINO"))
                return (72.7 * altura) - 58;
            else
                return (62.1 * altura) - 44.7;
        }

        //Método que retorna uma string contendo as informações da pessoa
        public override string ToString()
        {
            return (String.Format(" Nome: {0}\n Idade: {1} \n Altura: {2} \n Sexo: {3}\n", nome, idade, altura, sexo));
        }
    }
}
