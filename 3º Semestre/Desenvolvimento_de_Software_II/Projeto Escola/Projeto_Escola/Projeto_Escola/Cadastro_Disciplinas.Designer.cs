namespace Projeto_Escola
{
    partial class Cadastro_Disciplinas
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.lbl_cod = new System.Windows.Forms.Label();
            this.lbl_desc = new System.Windows.Forms.Label();
            this.txt_desc = new System.Windows.Forms.TextBox();
            this.lbl_sigla = new System.Windows.Forms.Label();
            this.txt_sig = new System.Windows.Forms.TextBox();
            this.gb_nav = new System.Windows.Forms.GroupBox();
            this.btnAnt = new System.Windows.Forms.Button();
            this.btnProx = new System.Windows.Forms.Button();
            this.btnPrim = new System.Windows.Forms.Button();
            this.btnUlt = new System.Windows.Forms.Button();
            this.Disciplina_dataGridView = new System.Windows.Forms.DataGridView();
            this.lbl_pesq = new System.Windows.Forms.Label();
            this.txt_Pesquisar = new System.Windows.Forms.TextBox();
            this.btn_incluir = new System.Windows.Forms.Button();
            this.btn_excluir = new System.Windows.Forms.Button();
            this.btn_alterar = new System.Windows.Forms.Button();
            this.btn_novo = new System.Windows.Forms.Button();
            this.btn_limpar = new System.Windows.Forms.Button();
            this.gb_nav.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Disciplina_dataGridView)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(24, 20);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(43, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Código:";
            // 
            // lbl_cod
            // 
            this.lbl_cod.AutoSize = true;
            this.lbl_cod.Location = new System.Drawing.Point(87, 20);
            this.lbl_cod.Name = "lbl_cod";
            this.lbl_cod.Size = new System.Drawing.Size(35, 13);
            this.lbl_cod.TabIndex = 1;
            this.lbl_cod.Text = "label2";
            // 
            // lbl_desc
            // 
            this.lbl_desc.AutoSize = true;
            this.lbl_desc.Location = new System.Drawing.Point(24, 58);
            this.lbl_desc.Name = "lbl_desc";
            this.lbl_desc.Size = new System.Drawing.Size(58, 13);
            this.lbl_desc.TabIndex = 2;
            this.lbl_desc.Text = "Descrição:";
            // 
            // txt_desc
            // 
            this.txt_desc.Location = new System.Drawing.Point(90, 55);
            this.txt_desc.Name = "txt_desc";
            this.txt_desc.Size = new System.Drawing.Size(244, 20);
            this.txt_desc.TabIndex = 3;
            // 
            // lbl_sigla
            // 
            this.lbl_sigla.AutoSize = true;
            this.lbl_sigla.Location = new System.Drawing.Point(24, 102);
            this.lbl_sigla.Name = "lbl_sigla";
            this.lbl_sigla.Size = new System.Drawing.Size(33, 13);
            this.lbl_sigla.TabIndex = 4;
            this.lbl_sigla.Text = "Sigla:";
            // 
            // txt_sig
            // 
            this.txt_sig.Location = new System.Drawing.Point(90, 99);
            this.txt_sig.Name = "txt_sig";
            this.txt_sig.Size = new System.Drawing.Size(100, 20);
            this.txt_sig.TabIndex = 5;
            // 
            // gb_nav
            // 
            this.gb_nav.Controls.Add(this.btnAnt);
            this.gb_nav.Controls.Add(this.btnProx);
            this.gb_nav.Controls.Add(this.btnPrim);
            this.gb_nav.Location = new System.Drawing.Point(27, 157);
            this.gb_nav.Name = "gb_nav";
            this.gb_nav.Size = new System.Drawing.Size(366, 57);
            this.gb_nav.TabIndex = 6;
            this.gb_nav.TabStop = false;
            this.gb_nav.Text = "Navegação";
            // 
            // btnAnt
            // 
            this.btnAnt.Location = new System.Drawing.Point(182, 23);
            this.btnAnt.Name = "btnAnt";
            this.btnAnt.Size = new System.Drawing.Size(75, 23);
            this.btnAnt.TabIndex = 2;
            this.btnAnt.Text = "Anterior";
            this.btnAnt.UseVisualStyleBackColor = true;
            this.btnAnt.Click += new System.EventHandler(this.btnAnt_Click);
            // 
            // btnProx
            // 
            this.btnProx.Location = new System.Drawing.Point(101, 23);
            this.btnProx.Name = "btnProx";
            this.btnProx.Size = new System.Drawing.Size(75, 23);
            this.btnProx.TabIndex = 1;
            this.btnProx.Text = "Próximo";
            this.btnProx.UseVisualStyleBackColor = true;
            this.btnProx.Click += new System.EventHandler(this.btnProx_Click);
            // 
            // btnPrim
            // 
            this.btnPrim.Location = new System.Drawing.Point(20, 23);
            this.btnPrim.Name = "btnPrim";
            this.btnPrim.Size = new System.Drawing.Size(75, 23);
            this.btnPrim.TabIndex = 0;
            this.btnPrim.Text = "Primeiro";
            this.btnPrim.UseVisualStyleBackColor = true;
            this.btnPrim.Click += new System.EventHandler(this.btnPrim_Click);
            // 
            // btnUlt
            // 
            this.btnUlt.Location = new System.Drawing.Point(290, 180);
            this.btnUlt.Name = "btnUlt";
            this.btnUlt.Size = new System.Drawing.Size(75, 23);
            this.btnUlt.TabIndex = 7;
            this.btnUlt.Text = "Último";
            this.btnUlt.UseVisualStyleBackColor = true;
            this.btnUlt.Click += new System.EventHandler(this.btnUlt_Click);
            // 
            // Disciplina_dataGridView
            // 
            this.Disciplina_dataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.Disciplina_dataGridView.Location = new System.Drawing.Point(27, 245);
            this.Disciplina_dataGridView.Name = "Disciplina_dataGridView";
            this.Disciplina_dataGridView.Size = new System.Drawing.Size(475, 150);
            this.Disciplina_dataGridView.TabIndex = 8;
            // 
            // lbl_pesq
            // 
            this.lbl_pesq.AutoSize = true;
            this.lbl_pesq.Location = new System.Drawing.Point(34, 420);
            this.lbl_pesq.Name = "lbl_pesq";
            this.lbl_pesq.Size = new System.Drawing.Size(222, 13);
            this.lbl_pesq.TabIndex = 9;
            this.lbl_pesq.Text = "Informe a sigla da disciplina a ser pesquisada:";
            // 
            // txt_Pesquisar
            // 
            this.txt_Pesquisar.Location = new System.Drawing.Point(262, 417);
            this.txt_Pesquisar.Name = "txt_Pesquisar";
            this.txt_Pesquisar.Size = new System.Drawing.Size(240, 20);
            this.txt_Pesquisar.TabIndex = 10;
            this.txt_Pesquisar.TextChanged += new System.EventHandler(this.textBox3_TextChanged);
            // 
            // btn_incluir
            // 
            this.btn_incluir.Location = new System.Drawing.Point(500, 48);
            this.btn_incluir.Name = "btn_incluir";
            this.btn_incluir.Size = new System.Drawing.Size(75, 23);
            this.btn_incluir.TabIndex = 11;
            this.btn_incluir.Text = "Incluir";
            this.btn_incluir.UseVisualStyleBackColor = true;
            this.btn_incluir.Click += new System.EventHandler(this.btn_incluir_Click);
            // 
            // btn_excluir
            // 
            this.btn_excluir.Location = new System.Drawing.Point(500, 92);
            this.btn_excluir.Name = "btn_excluir";
            this.btn_excluir.Size = new System.Drawing.Size(75, 23);
            this.btn_excluir.TabIndex = 12;
            this.btn_excluir.Text = "Excluir";
            this.btn_excluir.UseVisualStyleBackColor = true;
            this.btn_excluir.Click += new System.EventHandler(this.btn_excluir_Click);
            // 
            // btn_alterar
            // 
            this.btn_alterar.Location = new System.Drawing.Point(500, 133);
            this.btn_alterar.Name = "btn_alterar";
            this.btn_alterar.Size = new System.Drawing.Size(75, 23);
            this.btn_alterar.TabIndex = 13;
            this.btn_alterar.Text = "Alterar";
            this.btn_alterar.UseVisualStyleBackColor = true;
            this.btn_alterar.Click += new System.EventHandler(this.btn_alterar_Click);
            // 
            // btn_novo
            // 
            this.btn_novo.Location = new System.Drawing.Point(541, 180);
            this.btn_novo.Name = "btn_novo";
            this.btn_novo.Size = new System.Drawing.Size(84, 23);
            this.btn_novo.TabIndex = 14;
            this.btn_novo.Text = "Novo Registro";
            this.btn_novo.UseVisualStyleBackColor = true;
            this.btn_novo.Click += new System.EventHandler(this.btn_novo_Click);
            // 
            // btn_limpar
            // 
            this.btn_limpar.Location = new System.Drawing.Point(447, 180);
            this.btn_limpar.Name = "btn_limpar";
            this.btn_limpar.Size = new System.Drawing.Size(75, 23);
            this.btn_limpar.TabIndex = 15;
            this.btn_limpar.Text = "Limpar";
            this.btn_limpar.UseVisualStyleBackColor = true;
            this.btn_limpar.Click += new System.EventHandler(this.btn_limpar_Click);
            // 
            // Cadastro_Disciplinas
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(651, 451);
            this.Controls.Add(this.btn_limpar);
            this.Controls.Add(this.btn_novo);
            this.Controls.Add(this.btn_alterar);
            this.Controls.Add(this.btn_excluir);
            this.Controls.Add(this.btn_incluir);
            this.Controls.Add(this.txt_Pesquisar);
            this.Controls.Add(this.lbl_pesq);
            this.Controls.Add(this.Disciplina_dataGridView);
            this.Controls.Add(this.btnUlt);
            this.Controls.Add(this.gb_nav);
            this.Controls.Add(this.txt_sig);
            this.Controls.Add(this.lbl_sigla);
            this.Controls.Add(this.txt_desc);
            this.Controls.Add(this.lbl_desc);
            this.Controls.Add(this.lbl_cod);
            this.Controls.Add(this.label1);
            this.Name = "Cadastro_Disciplinas";
            this.Text = "Cadastro_Disciplinas";
            this.Load += new System.EventHandler(this.Cadastro_Disciplinas_Load);
            this.gb_nav.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Disciplina_dataGridView)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lbl_cod;
        private System.Windows.Forms.Label lbl_desc;
        private System.Windows.Forms.TextBox txt_desc;
        private System.Windows.Forms.Label lbl_sigla;
        private System.Windows.Forms.TextBox txt_sig;
        private System.Windows.Forms.GroupBox gb_nav;
        private System.Windows.Forms.Button btnAnt;
        private System.Windows.Forms.Button btnProx;
        private System.Windows.Forms.Button btnPrim;
        private System.Windows.Forms.Button btnUlt;
        private System.Windows.Forms.DataGridView Disciplina_dataGridView;
        private System.Windows.Forms.Label lbl_pesq;
        private System.Windows.Forms.TextBox txt_Pesquisar;
        private System.Windows.Forms.Button btn_incluir;
        private System.Windows.Forms.Button btn_excluir;
        private System.Windows.Forms.Button btn_alterar;
        private System.Windows.Forms.Button btn_novo;
        private System.Windows.Forms.Button btn_limpar;
    }
}