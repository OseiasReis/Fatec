namespace Projeto_Escola
{
    partial class Consulta_Cadastral_de_Alunos
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Consulta_Cadastral_de_Alunos));
            this.label1 = new System.Windows.Forms.Label();
            this.cmb_escolha = new System.Windows.Forms.ComboBox();
            this.txt_pesq = new System.Windows.Forms.TextBox();
            this.dgv_cons_aluno = new System.Windows.Forms.DataGridView();
            this.btn_imp = new System.Windows.Forms.Button();
            this.btn_visu = new System.Windows.Forms.Button();
            this.btn_qtsl = new System.Windows.Forms.Button();
            this.printDialog1 = new System.Windows.Forms.PrintDialog();
            this.printDocument1 = new System.Drawing.Printing.PrintDocument();
            this.printPreviewDialog1 = new System.Windows.Forms.PrintPreviewDialog();
            ((System.ComponentModel.ISupportInitialize)(this.dgv_cons_aluno)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(46, 51);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(175, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Escolha o campo a ser pesquisado:";
            // 
            // cmb_escolha
            // 
            this.cmb_escolha.FormattingEnabled = true;
            this.cmb_escolha.Items.AddRange(new object[] {
            "Matricula",
            "Nome",
            "Cidade"});
            this.cmb_escolha.Location = new System.Drawing.Point(227, 48);
            this.cmb_escolha.Name = "cmb_escolha";
            this.cmb_escolha.Size = new System.Drawing.Size(121, 21);
            this.cmb_escolha.TabIndex = 1;
            // 
            // txt_pesq
            // 
            this.txt_pesq.Location = new System.Drawing.Point(368, 48);
            this.txt_pesq.Name = "txt_pesq";
            this.txt_pesq.Size = new System.Drawing.Size(296, 20);
            this.txt_pesq.TabIndex = 2;
            this.txt_pesq.TextChanged += new System.EventHandler(this.txt_pesq_TextChanged_1);
            // 
            // dgv_cons_aluno
            // 
            this.dgv_cons_aluno.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgv_cons_aluno.Location = new System.Drawing.Point(12, 108);
            this.dgv_cons_aluno.Name = "dgv_cons_aluno";
            this.dgv_cons_aluno.Size = new System.Drawing.Size(669, 186);
            this.dgv_cons_aluno.TabIndex = 3;
            // 
            // btn_imp
            // 
            this.btn_imp.Location = new System.Drawing.Point(49, 316);
            this.btn_imp.Name = "btn_imp";
            this.btn_imp.Size = new System.Drawing.Size(75, 23);
            this.btn_imp.TabIndex = 4;
            this.btn_imp.Text = "Imprimir";
            this.btn_imp.UseVisualStyleBackColor = true;
            this.btn_imp.Click += new System.EventHandler(this.btn_imp_Click);
            // 
            // btn_visu
            // 
            this.btn_visu.Location = new System.Drawing.Point(303, 316);
            this.btn_visu.Name = "btn_visu";
            this.btn_visu.Size = new System.Drawing.Size(75, 23);
            this.btn_visu.TabIndex = 5;
            this.btn_visu.Text = "Visualizar";
            this.btn_visu.UseVisualStyleBackColor = true;
            this.btn_visu.Click += new System.EventHandler(this.btn_visu_Click);
            // 
            // btn_qtsl
            // 
            this.btn_qtsl.Location = new System.Drawing.Point(546, 309);
            this.btn_qtsl.Name = "btn_qtsl";
            this.btn_qtsl.Size = new System.Drawing.Size(85, 36);
            this.btn_qtsl.TabIndex = 6;
            this.btn_qtsl.Text = "Quatidade de Selecionados";
            this.btn_qtsl.UseVisualStyleBackColor = true;
            this.btn_qtsl.Click += new System.EventHandler(this.btn_qtsl_Click);
            // 
            // printDialog1
            // 
            this.printDialog1.UseEXDialog = true;
            // 
            // printDocument1
            // 
            this.printDocument1.PrintPage += new System.Drawing.Printing.PrintPageEventHandler(this.printDocument1_PrintPage);
            // 
            // printPreviewDialog1
            // 
            this.printPreviewDialog1.AutoScrollMargin = new System.Drawing.Size(0, 0);
            this.printPreviewDialog1.AutoScrollMinSize = new System.Drawing.Size(0, 0);
            this.printPreviewDialog1.ClientSize = new System.Drawing.Size(400, 300);
            this.printPreviewDialog1.Enabled = true;
            this.printPreviewDialog1.Icon = ((System.Drawing.Icon)(resources.GetObject("printPreviewDialog1.Icon")));
            this.printPreviewDialog1.Name = "printPreviewDialog1";
            this.printPreviewDialog1.Visible = false;
            // 
            // Consulta_Cadastral_de_Alunos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(693, 362);
            this.Controls.Add(this.btn_qtsl);
            this.Controls.Add(this.btn_visu);
            this.Controls.Add(this.btn_imp);
            this.Controls.Add(this.dgv_cons_aluno);
            this.Controls.Add(this.txt_pesq);
            this.Controls.Add(this.cmb_escolha);
            this.Controls.Add(this.label1);
            this.Name = "Consulta_Cadastral_de_Alunos";
            this.Text = "Consulta_Cadastral_de_Alunos";
            this.Load += new System.EventHandler(this.Consulta_Cadastral_de_Alunos_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgv_cons_aluno)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox cmb_escolha;
        private System.Windows.Forms.TextBox txt_pesq;
        private System.Windows.Forms.DataGridView dgv_cons_aluno;
        private System.Windows.Forms.Button btn_imp;
        private System.Windows.Forms.Button btn_visu;
        private System.Windows.Forms.Button btn_qtsl;
        private System.Windows.Forms.PrintDialog printDialog1;
        private System.Drawing.Printing.PrintDocument printDocument1;
        private System.Windows.Forms.PrintPreviewDialog printPreviewDialog1;
    }
}