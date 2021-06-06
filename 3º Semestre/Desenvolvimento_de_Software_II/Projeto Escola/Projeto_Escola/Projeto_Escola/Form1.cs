using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Projeto_Escola
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void alunosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Cadastro_De_Alunos ca = new Cadastro_De_Alunos();
            ca.MdiParent = this;
            ca.Show();
        }

        private void disciplinasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Cadastro_Disciplinas cd = new Cadastro_Disciplinas();
            cd.MdiParent = this;
            cd.Show();
        }

        private void alunosToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            Notas_Aluno na = new Notas_Aluno();
            na.MdiParent = this;
            na.Show();
        }

        private void disciplinasToolStripMenuItem2_Click(object sender, EventArgs e)
        {
            Relatorios_Cadastrais_Disciplina rcd = new Relatorios_Cadastrais_Disciplina();
            rcd.MdiParent = this;
            rcd.Show();
        }

        private void alunosToolStripMenuItem2_Click(object sender, EventArgs e)
        {
            Relatorios_Cadastrais_Alunos rca = new Relatorios_Cadastrais_Alunos();
            rca.MdiParent = this;
            rca.Show();
        }

        private void analíticoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Relatorio_Analitico ra = new Relatorio_Analitico();
            ra.MdiParent = this;
            ra.Show();
        }

        private void disciplinasToolStripMenuItem3_Click(object sender, EventArgs e)
        {
            Consulta_Cadastral_Disciplinas ccd = new Consulta_Cadastral_Disciplinas();
            ccd.MdiParent = this;
            ccd.Show();
        }

        private void alunosToolStripMenuItem3_Click(object sender, EventArgs e)
        {
            Consulta_Cadastral_de_Alunos cca = new Consulta_Cadastral_de_Alunos();
            cca.MdiParent = this;
            cca.Show();
        }

        private void disciplinasToolStripMenuItem4_Click(object sender, EventArgs e)
        {
            Consulta_Analitica_Disciplina cad = new Consulta_Analitica_Disciplina();
            cad.MdiParent = this;
            cad.Show();
        }

        private void alunosToolStripMenuItem4_Click(object sender, EventArgs e)
        {
            Consulta_Analitica_Aluno caa = new Consulta_Analitica_Aluno();
            caa.MdiParent = this;
            caa.Show();
        }

        private void mençãoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Consulta_Analitica_Mencao cam = new Consulta_Analitica_Mencao();
            cam.MdiParent = this;
            cam.Show();
        }
    }
}
