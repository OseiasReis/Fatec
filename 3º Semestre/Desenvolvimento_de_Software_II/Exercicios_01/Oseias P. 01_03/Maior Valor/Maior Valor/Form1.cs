using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Maior_Valor
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int valorA = System.Convert.ToInt16(txtValorA.Text);
            int valorB = System.Convert.ToInt16(txtValorB.Text);
            int valorC = System.Convert.ToInt16(txtValorC.Text);
            if (valorA > valorB)
            {
                if (valorA > valorC){
                    lblResposta.Text = "O Maior Valor é o A ";
            }
                else
                {
                    lblResposta.Text = "O Maior Valor é o C";
                }
            }
                else if (valorB > valorC)
                {
                    lblResposta.Text = "O Maior Valor é o B";
                }
                else
                {
                    lblResposta.Text = "O Maior Valor é o C";
                }
        }
        
    }
}