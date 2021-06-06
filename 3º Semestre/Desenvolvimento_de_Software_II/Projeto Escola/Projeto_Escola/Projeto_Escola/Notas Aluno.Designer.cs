namespace Projeto_Escola
{
    partial class Notas_Aluno
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
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.cmb_aluno = new System.Windows.Forms.ComboBox();
            this.cmb_disc = new System.Windows.Forms.ComboBox();
            this.cmb_menc = new System.Windows.Forms.ComboBox();
            this.dgv_adm = new System.Windows.Forms.DataGridView();
            this.lbl_matricula = new System.Windows.Forms.Label();
            this.lbl_disc = new System.Windows.Forms.Label();
            this.btn_registrar = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dgv_adm)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(67, 45);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(37, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Aluno:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(67, 83);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(55, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Disciplina:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(67, 119);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(49, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "Menção:";
            // 
            // cmb_aluno
            // 
            this.cmb_aluno.FormattingEnabled = true;
            this.cmb_aluno.Location = new System.Drawing.Point(129, 42);
            this.cmb_aluno.Name = "cmb_aluno";
            this.cmb_aluno.Size = new System.Drawing.Size(290, 21);
            this.cmb_aluno.TabIndex = 3;
            // 
            // cmb_disc
            // 
            this.cmb_disc.FormattingEnabled = true;
            this.cmb_disc.Location = new System.Drawing.Point(129, 80);
            this.cmb_disc.Name = "cmb_disc";
            this.cmb_disc.Size = new System.Drawing.Size(290, 21);
            this.cmb_disc.TabIndex = 4;
            // 
            // cmb_menc
            // 
            this.cmb_menc.FormattingEnabled = true;
            this.cmb_menc.Location = new System.Drawing.Point(129, 116);
            this.cmb_menc.Name = "cmb_menc";
            this.cmb_menc.Size = new System.Drawing.Size(86, 21);
            this.cmb_menc.TabIndex = 5;
            // 
            // dgv_adm
            // 
            this.dgv_adm.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgv_adm.Location = new System.Drawing.Point(12, 155);
            this.dgv_adm.Name = "dgv_adm";
            this.dgv_adm.Size = new System.Drawing.Size(651, 264);
            this.dgv_adm.TabIndex = 6;
            // 
            // lbl_matricula
            // 
            this.lbl_matricula.AutoSize = true;
            this.lbl_matricula.Location = new System.Drawing.Point(465, 45);
            this.lbl_matricula.Name = "lbl_matricula";
            this.lbl_matricula.Size = new System.Drawing.Size(35, 13);
            this.lbl_matricula.TabIndex = 7;
            this.lbl_matricula.Text = "label4";
            // 
            // lbl_disc
            // 
            this.lbl_disc.AutoSize = true;
            this.lbl_disc.Location = new System.Drawing.Point(465, 83);
            this.lbl_disc.Name = "lbl_disc";
            this.lbl_disc.Size = new System.Drawing.Size(35, 13);
            this.lbl_disc.TabIndex = 8;
            this.lbl_disc.Text = "label5";
            // 
            // btn_registrar
            // 
            this.btn_registrar.Location = new System.Drawing.Point(588, 114);
            this.btn_registrar.Name = "btn_registrar";
            this.btn_registrar.Size = new System.Drawing.Size(75, 23);
            this.btn_registrar.TabIndex = 9;
            this.btn_registrar.Text = "Registrar";
            this.btn_registrar.UseVisualStyleBackColor = true;
            this.btn_registrar.Click += new System.EventHandler(this.btn_registrar_Click);
            // 
            // Notas_Aluno
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(675, 431);
            this.Controls.Add(this.btn_registrar);
            this.Controls.Add(this.lbl_disc);
            this.Controls.Add(this.lbl_matricula);
            this.Controls.Add(this.dgv_adm);
            this.Controls.Add(this.cmb_menc);
            this.Controls.Add(this.cmb_disc);
            this.Controls.Add(this.cmb_aluno);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "Notas_Aluno";
            this.Text = "Notas_Aluno";
            this.Load += new System.EventHandler(this.Notas_Aluno_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgv_adm)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ComboBox cmb_aluno;
        private System.Windows.Forms.ComboBox cmb_disc;
        private System.Windows.Forms.ComboBox cmb_menc;
        private System.Windows.Forms.DataGridView dgv_adm;
        private System.Windows.Forms.Label lbl_matricula;
        private System.Windows.Forms.Label lbl_disc;
        private System.Windows.Forms.Button btn_registrar;
    }
}