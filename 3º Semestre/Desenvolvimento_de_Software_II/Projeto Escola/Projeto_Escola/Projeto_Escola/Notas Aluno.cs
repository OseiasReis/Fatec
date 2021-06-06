using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.OleDb;

namespace Projeto_Escola
{
    public partial class Notas_Aluno : Form
    {
        OleDbConnection conn = Conexao.obterConexao();
        OleDbDataReader dr_disciplina;
        BindingSource bs_disciplina = new BindingSource();

        OleDbDataReader dr_aluno;
        BindingSource bs_aluno = new BindingSource();

        OleDbDataReader dr_menc;
        BindingSource bs_menc = new BindingSource();

        OleDbDataReader dr_reg_notas;
        BindingSource bs_reg_notas = new BindingSource();
        String _query;

        public Notas_Aluno()
        {
            InitializeComponent();
        }

        private void carregar_aluno()
        {
            _query = "SELECT * from alunos order by Nome";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_aluno = _dataCommand.ExecuteReader();
            if (dr_aluno.HasRows == true)
            {
                bs_aluno.DataSource = dr_aluno;
                cmb_aluno.DataSource = bs_aluno;
                cmb_aluno.DisplayMember = "Nome";
                cmb_aluno.ValueMember = "Matricula";
                lbl_matricula.Text = cmb_aluno.SelectedValue.ToString();
            }
            else
            {
                MessageBox.Show("Não temos Alunos cadastrados !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                dgv_adm.Refresh();
            }
        }

        private void carregar_disciplina()
        {
            _query = "SELECT * from disciplina Sigla";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_disciplina = _dataCommand.ExecuteReader();
            if (dr_disciplina.HasRows == true)
            {
                bs_disciplina.DataSource = dr_disciplina;
                cmb_disc.DataSource = bs_disciplina;
                cmb_disc.DisplayMember = "Sigla";
                cmb_disc.DisplayMember = "Descrição";
                cmb_disc.ValueMember = "Código";
                lbl_disc.Text = cmb_disc.SelectedValue.ToString();
            }
            else
            {
                MessageBox.Show("Não temos Disciplinas cadastrados !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                dgv_adm.Refresh();
            }
        }

        private void carregar_mencao()
        {
            _query = "SELECT * from mencao Mencao";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_menc = _dataCommand.ExecuteReader();
            if (dr_menc.HasRows == true)
            {
                bs_menc.DataSource = dr_menc;
                cmb_menc.DataSource = bs_menc;
                cmb_menc.DisplayMember = "Mencao";
            }
            else
            {
                MessageBox.Show("Não temos Menção cadastrados !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                dgv_adm.Refresh();
            }
        }

        private void carregar_grid()
        {
            _query = "SELECT alunos.Nome, disciplina.Sigla, disciplina.Descrição, mencao.Mencao FROM mencao INNER JOIN (disciplina INNER JOIN (aluno INNER JOIN reg_notas ON alunos.Matricula = reg_notas.Matricula) ON disciplina.Código = reg_notas.Cod_Disc) ON mencao.Mencao = reg_notas.mencao;";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_reg_notas = _dataCommand.ExecuteReader();
            if (dr_reg_notas.HasRows == true)
            {
                bs_reg_notas.DataSource = dr_menc;
                dgv_adm.DataSource = bs_menc;
            }
            else
            {
                MessageBox.Show("Não temos Menção cadastrados !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                dgv_adm.Refresh();
            }
        }

        private void btn_registrar_Click(object sender, EventArgs e)
        {

            _query = "Select * from alunos where Matricula = '" + cmb_aluno + "';";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_aluno = _dataCommand.ExecuteReader();

            lbl_matricula.DataBindings.Add("Text", bs_aluno, "Matricula");
            lbl_matricula.DataBindings.Clear();

            _query = "Select * from disciplina where Cod_Disc = '" + cmb_disc + "';";
            _dataCommand = new OleDbCommand(_query, conn);
            dr_disciplina = _dataCommand.ExecuteReader();

            lbl_disc.DataBindings.Add("Text", bs_aluno, "Cod_Disc");
            lbl_disc.DataBindings.Clear();

                _query = "Insert into reg_notas (Matricula,Cod_Disc,Mencao) Values ";
                _query += "('" + cmb_aluno.Text + "','" + cmb_disc.Text + "','" + cmb_menc.Text + "')";
                try
                {
                    _dataCommand = new OleDbCommand(_query, conn);
                    _dataCommand.ExecuteNonQuery();
                    carregar_grid();
                    MessageBox.Show("Incluido com sucesso !!!!", "Inclusão", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                }
                catch (Exception e2)
                {
                    MessageBox.Show("Problemas com a Inclusão !!!!\n" + e2, "Inclusão", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
        }

        private void Notas_Aluno_Load(object sender, EventArgs e)
        {
            carregar_aluno();
            carregar_disciplina();
            carregar_mencao();
            carregar_grid();
        }
    }
}
