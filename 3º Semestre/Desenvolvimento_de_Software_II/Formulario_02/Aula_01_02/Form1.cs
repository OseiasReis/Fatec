using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Aula_01_02
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnSair_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnLimpar_Click(object sender, EventArgs e)
        {
            minhaLabel.Text = "";
        }

        private void btnExibir_Click(object sender, EventArgs e)
        {
            minhaLabel.Text = "Meu Primeiro programa!!!";
        }

        private void btnExe1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Esta é uma mensagem de alerta.", "Alerta",
            MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
        }

        private void btnExe2_Click(object sender, EventArgs e)
        {
            string message = "Poderia informar seus dados para futuro contato?";
            string caption = "Pergunta";
            MessageBoxButtons buttons = MessageBoxButtons.YesNo;
            DialogResult result;

            result = MessageBox.Show(message, caption, buttons);

            if(result==System.Windows.Forms.DialogResult.Yes)
            {
                MessageBox.Show("OK Obrigado! Em breve entrarei em contato!","Resposta SIM",MessageBoxButtons.OK);
            }
            else
            {
                MessageBox.Show("OK Sem problemas! ","Resposta NÃO", MessageBoxButtons.OK);
            }
        }

        private void btnExe3_Click(object sender, EventArgs e)
        {
            DialogResult resultado = MessageBox.Show("É isso mesmo que pensou?","Pergunta",
            MessageBoxButtons.YesNoCancel,
            MessageBoxIcon.Question,
            MessageBoxDefaultButton.Button2);
        }
    }
}
