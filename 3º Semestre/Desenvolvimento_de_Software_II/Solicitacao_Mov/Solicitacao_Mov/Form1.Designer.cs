namespace Solicitacao_Mov
{
    partial class Form1
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
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.Label dataLabel;
            System.Windows.Forms.Label solicitanteLabel;
            System.Windows.Forms.Label desc_ProdLabel;
            System.Windows.Forms.Label patrimônioLabel;
            System.Windows.Forms.Label loc_OriLabel;
            System.Windows.Forms.Label loc_DestLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.lblTitulo = new System.Windows.Forms.Label();
            this.bD_SolictDataSet = new Solicitacao_Mov.BD_SolictDataSet();
            this.bD_SolicitBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.bD_SolicitTableAdapter = new Solicitacao_Mov.BD_SolictDataSetTableAdapters.BD_SolicitTableAdapter();
            this.tableAdapterManager = new Solicitacao_Mov.BD_SolictDataSetTableAdapters.TableAdapterManager();
            this.bD_SolicitBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorCountItem = new System.Windows.Forms.ToolStripLabel();
            this.bindingNavigatorDeleteItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveFirstItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMovePreviousItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorPositionItem = new System.Windows.Forms.ToolStripTextBox();
            this.bindingNavigatorSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorMoveNextItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveLastItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.bD_SolicitBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.txt_data = new System.Windows.Forms.MaskedTextBox();
            this.txt_solic = new System.Windows.Forms.TextBox();
            this.txt_desc = new System.Windows.Forms.TextBox();
            this.txt_patri = new System.Windows.Forms.TextBox();
            this.txt_loc_ori = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.txt_loc_dest = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.btnUlt = new System.Windows.Forms.Button();
            this.btnProx = new System.Windows.Forms.Button();
            this.btnAnt = new System.Windows.Forms.Button();
            this.btnPrim = new System.Windows.Forms.Button();
            this.btn_incluir = new System.Windows.Forms.Button();
            this.bD_SolicitDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn6 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn7 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btn_Pes = new System.Windows.Forms.Button();
            dataLabel = new System.Windows.Forms.Label();
            solicitanteLabel = new System.Windows.Forms.Label();
            desc_ProdLabel = new System.Windows.Forms.Label();
            patrimônioLabel = new System.Windows.Forms.Label();
            loc_OriLabel = new System.Windows.Forms.Label();
            loc_DestLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.bD_SolictDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bD_SolicitBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bD_SolicitBindingNavigator)).BeginInit();
            this.bD_SolicitBindingNavigator.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bD_SolicitDataGridView)).BeginInit();
            this.SuspendLayout();
            // 
            // dataLabel
            // 
            dataLabel.AutoSize = true;
            dataLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataLabel.Location = new System.Drawing.Point(96, 83);
            dataLabel.Name = "dataLabel";
            dataLabel.Size = new System.Drawing.Size(64, 25);
            dataLabel.TabIndex = 4;
            dataLabel.Text = "Data:";
            // 
            // solicitanteLabel
            // 
            solicitanteLabel.AutoSize = true;
            solicitanteLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            solicitanteLabel.Location = new System.Drawing.Point(321, 83);
            solicitanteLabel.Name = "solicitanteLabel";
            solicitanteLabel.Size = new System.Drawing.Size(120, 25);
            solicitanteLabel.TabIndex = 6;
            solicitanteLabel.Text = "Solicitante:";
            // 
            // desc_ProdLabel
            // 
            desc_ProdLabel.AutoSize = true;
            desc_ProdLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            desc_ProdLabel.Location = new System.Drawing.Point(6, 16);
            desc_ProdLabel.Name = "desc_ProdLabel";
            desc_ProdLabel.Size = new System.Drawing.Size(182, 20);
            desc_ProdLabel.TabIndex = 8;
            desc_ProdLabel.Text = "Descrição de Produto";
            // 
            // patrimônioLabel
            // 
            patrimônioLabel.AutoSize = true;
            patrimônioLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            patrimônioLabel.Location = new System.Drawing.Point(50, 55);
            patrimônioLabel.Name = "patrimônioLabel";
            patrimônioLabel.Size = new System.Drawing.Size(94, 20);
            patrimônioLabel.TabIndex = 10;
            patrimônioLabel.Text = "Patrimônio";
            // 
            // loc_OriLabel
            // 
            loc_OriLabel.AutoSize = true;
            loc_OriLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            loc_OriLabel.Location = new System.Drawing.Point(13, 57);
            loc_OriLabel.Name = "loc_OriLabel";
            loc_OriLabel.Size = new System.Drawing.Size(144, 20);
            loc_OriLabel.TabIndex = 12;
            loc_OriLabel.Text = "Local de Origem:";
            // 
            // loc_DestLabel
            // 
            loc_DestLabel.AutoSize = true;
            loc_DestLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            loc_DestLabel.Location = new System.Drawing.Point(10, 16);
            loc_DestLabel.Name = "loc_DestLabel";
            loc_DestLabel.Size = new System.Drawing.Size(149, 20);
            loc_DestLabel.TabIndex = 14;
            loc_DestLabel.Text = "Local de Destino:";
            // 
            // lblTitulo
            // 
            this.lblTitulo.AutoSize = true;
            this.lblTitulo.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblTitulo.ForeColor = System.Drawing.Color.Red;
            this.lblTitulo.Location = new System.Drawing.Point(58, 31);
            this.lblTitulo.Name = "lblTitulo";
            this.lblTitulo.Size = new System.Drawing.Size(828, 20);
            this.lblTitulo.TabIndex = 0;
            this.lblTitulo.Text = "SOLICITAÇÃO/AUTORIZAÇÃO DE MOVIMENTAÇÃO DE BENS DE INFORMÁTICA ENTRE SETORES";
            // 
            // bD_SolictDataSet
            // 
            this.bD_SolictDataSet.DataSetName = "BD_SolictDataSet";
            this.bD_SolictDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // bD_SolicitBindingSource
            // 
            this.bD_SolicitBindingSource.DataMember = "BD_Solicit";
            this.bD_SolicitBindingSource.DataSource = this.bD_SolictDataSet;
            // 
            // bD_SolicitTableAdapter
            // 
            this.bD_SolicitTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.BD_SolicitTableAdapter = this.bD_SolicitTableAdapter;
            this.tableAdapterManager.UpdateOrder = Solicitacao_Mov.BD_SolictDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // bD_SolicitBindingNavigator
            // 
            this.bD_SolicitBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.bD_SolicitBindingNavigator.BindingSource = this.bD_SolicitBindingSource;
            this.bD_SolicitBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.bD_SolicitBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.bD_SolicitBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bindingNavigatorMoveFirstItem,
            this.bindingNavigatorMovePreviousItem,
            this.bindingNavigatorSeparator,
            this.bindingNavigatorPositionItem,
            this.bindingNavigatorCountItem,
            this.bindingNavigatorSeparator1,
            this.bindingNavigatorMoveNextItem,
            this.bindingNavigatorMoveLastItem,
            this.bindingNavigatorSeparator2,
            this.bindingNavigatorAddNewItem,
            this.bindingNavigatorDeleteItem,
            this.bD_SolicitBindingNavigatorSaveItem});
            this.bD_SolicitBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.bD_SolicitBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.bD_SolicitBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.bD_SolicitBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.bD_SolicitBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.bD_SolicitBindingNavigator.Name = "bD_SolicitBindingNavigator";
            this.bD_SolicitBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.bD_SolicitBindingNavigator.Size = new System.Drawing.Size(954, 25);
            this.bD_SolicitBindingNavigator.TabIndex = 1;
            this.bD_SolicitBindingNavigator.Text = "bindingNavigator1";
            // 
            // bindingNavigatorAddNewItem
            // 
            this.bindingNavigatorAddNewItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorAddNewItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorAddNewItem.Image")));
            this.bindingNavigatorAddNewItem.Name = "bindingNavigatorAddNewItem";
            this.bindingNavigatorAddNewItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorAddNewItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorAddNewItem.Text = "Add new";
            // 
            // bindingNavigatorCountItem
            // 
            this.bindingNavigatorCountItem.Name = "bindingNavigatorCountItem";
            this.bindingNavigatorCountItem.Size = new System.Drawing.Size(35, 22);
            this.bindingNavigatorCountItem.Text = "of {0}";
            this.bindingNavigatorCountItem.ToolTipText = "Total number of items";
            // 
            // bindingNavigatorDeleteItem
            // 
            this.bindingNavigatorDeleteItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorDeleteItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorDeleteItem.Image")));
            this.bindingNavigatorDeleteItem.Name = "bindingNavigatorDeleteItem";
            this.bindingNavigatorDeleteItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorDeleteItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorDeleteItem.Text = "Delete";
            // 
            // bindingNavigatorMoveFirstItem
            // 
            this.bindingNavigatorMoveFirstItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveFirstItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveFirstItem.Image")));
            this.bindingNavigatorMoveFirstItem.Name = "bindingNavigatorMoveFirstItem";
            this.bindingNavigatorMoveFirstItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveFirstItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveFirstItem.Text = "Move first";
            // 
            // bindingNavigatorMovePreviousItem
            // 
            this.bindingNavigatorMovePreviousItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMovePreviousItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMovePreviousItem.Image")));
            this.bindingNavigatorMovePreviousItem.Name = "bindingNavigatorMovePreviousItem";
            this.bindingNavigatorMovePreviousItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMovePreviousItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMovePreviousItem.Text = "Move previous";
            // 
            // bindingNavigatorSeparator
            // 
            this.bindingNavigatorSeparator.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorPositionItem
            // 
            this.bindingNavigatorPositionItem.AccessibleName = "Position";
            this.bindingNavigatorPositionItem.AutoSize = false;
            this.bindingNavigatorPositionItem.Name = "bindingNavigatorPositionItem";
            this.bindingNavigatorPositionItem.Size = new System.Drawing.Size(50, 23);
            this.bindingNavigatorPositionItem.Text = "0";
            this.bindingNavigatorPositionItem.ToolTipText = "Current position";
            // 
            // bindingNavigatorSeparator1
            // 
            this.bindingNavigatorSeparator1.Name = "bindingNavigatorSeparator1";
            this.bindingNavigatorSeparator1.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorMoveNextItem
            // 
            this.bindingNavigatorMoveNextItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveNextItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveNextItem.Image")));
            this.bindingNavigatorMoveNextItem.Name = "bindingNavigatorMoveNextItem";
            this.bindingNavigatorMoveNextItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveNextItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveNextItem.Text = "Move next";
            // 
            // bindingNavigatorMoveLastItem
            // 
            this.bindingNavigatorMoveLastItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveLastItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveLastItem.Image")));
            this.bindingNavigatorMoveLastItem.Name = "bindingNavigatorMoveLastItem";
            this.bindingNavigatorMoveLastItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveLastItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveLastItem.Text = "Move last";
            // 
            // bindingNavigatorSeparator2
            // 
            this.bindingNavigatorSeparator2.Name = "bindingNavigatorSeparator2";
            this.bindingNavigatorSeparator2.Size = new System.Drawing.Size(6, 25);
            // 
            // bD_SolicitBindingNavigatorSaveItem
            // 
            this.bD_SolicitBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bD_SolicitBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("bD_SolicitBindingNavigatorSaveItem.Image")));
            this.bD_SolicitBindingNavigatorSaveItem.Name = "bD_SolicitBindingNavigatorSaveItem";
            this.bD_SolicitBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.bD_SolicitBindingNavigatorSaveItem.Text = "Save Data";
            this.bD_SolicitBindingNavigatorSaveItem.Click += new System.EventHandler(this.bD_SolicitBindingNavigatorSaveItem_Click);
            // 
            // txt_data
            // 
            this.txt_data.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.bD_SolicitBindingSource, "Data", true));
            this.txt_data.Location = new System.Drawing.Point(161, 89);
            this.txt_data.Mask = "00/00/0000";
            this.txt_data.Name = "txt_data";
            this.txt_data.Size = new System.Drawing.Size(76, 20);
            this.txt_data.TabIndex = 5;
            this.txt_data.ValidatingType = typeof(System.DateTime);
            // 
            // txt_solic
            // 
            this.txt_solic.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.bD_SolicitBindingSource, "Solicitante", true));
            this.txt_solic.Location = new System.Drawing.Point(446, 89);
            this.txt_solic.Name = "txt_solic";
            this.txt_solic.Size = new System.Drawing.Size(451, 20);
            this.txt_solic.TabIndex = 7;
            // 
            // txt_desc
            // 
            this.txt_desc.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.bD_SolicitBindingSource, "Desc_Prod", true));
            this.txt_desc.Location = new System.Drawing.Point(195, 18);
            this.txt_desc.Name = "txt_desc";
            this.txt_desc.Size = new System.Drawing.Size(218, 20);
            this.txt_desc.TabIndex = 9;
            this.txt_desc.TextChanged += new System.EventHandler(this.txt_desc_TextChanged);
            // 
            // txt_patri
            // 
            this.txt_patri.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.bD_SolicitBindingSource, "Patrimônio", true));
            this.txt_patri.Location = new System.Drawing.Point(195, 57);
            this.txt_patri.Name = "txt_patri";
            this.txt_patri.Size = new System.Drawing.Size(218, 20);
            this.txt_patri.TabIndex = 11;
            // 
            // txt_loc_ori
            // 
            this.txt_loc_ori.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.bD_SolicitBindingSource, "Loc_Ori", true));
            this.txt_loc_ori.Location = new System.Drawing.Point(195, 59);
            this.txt_loc_ori.Name = "txt_loc_ori";
            this.txt_loc_ori.Size = new System.Drawing.Size(218, 20);
            this.txt_loc_ori.TabIndex = 13;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(57, 135);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(693, 20);
            this.label1.TabIndex = 16;
            this.label1.Text = "Solicito realizar a movimentação dos bens de informática abaixo relacionados, con" +
                "forme locais de";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(756, 135);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(152, 20);
            this.label2.TabIndex = 17;
            this.label2.Text = "origem e de destino.";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(58, 172);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(826, 20);
            this.label3.TabIndex = 18;
            this.label3.Text = "Informamos ainda, que a formalização das transferências junto ao setor de patrimô" +
                "nio será de responsabilidade dos";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(39, 192);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(267, 20);
            this.label4.TabIndex = 19;
            this.label4.Text = "setores de origem e de recebimento.";
            // 
            // txt_loc_dest
            // 
            this.txt_loc_dest.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.bD_SolicitBindingSource, "Loc_Dest", true));
            this.txt_loc_dest.Location = new System.Drawing.Point(195, 19);
            this.txt_loc_dest.Name = "txt_loc_dest";
            this.txt_loc_dest.Size = new System.Drawing.Size(218, 20);
            this.txt_loc_dest.TabIndex = 15;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(29, 445);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(109, 17);
            this.label5.TabIndex = 21;
            this.label5.Text = "Observação 1";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(29, 473);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(565, 13);
            this.label6.TabIndex = 22;
            this.label6.Text = "A efetiva movimentação será realizada apenas após as assinaturas dessa solicitaçã" +
                "o/autorização.";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.Location = new System.Drawing.Point(29, 486);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(653, 13);
            this.label7.TabIndex = 23;
            this.label7.Text = "E a formalização da transferencia junto ao patrimônio é de responsabilidade dos s" +
                "etores de origem e recebimento.";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.txt_patri);
            this.groupBox1.Controls.Add(desc_ProdLabel);
            this.groupBox1.Controls.Add(patrimônioLabel);
            this.groupBox1.Controls.Add(this.txt_desc);
            this.groupBox1.Location = new System.Drawing.Point(47, 215);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(427, 89);
            this.groupBox1.TabIndex = 24;
            this.groupBox1.TabStop = false;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.txt_loc_ori);
            this.groupBox2.Controls.Add(loc_DestLabel);
            this.groupBox2.Controls.Add(loc_OriLabel);
            this.groupBox2.Controls.Add(this.txt_loc_dest);
            this.groupBox2.Location = new System.Drawing.Point(496, 215);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(427, 89);
            this.groupBox2.TabIndex = 25;
            this.groupBox2.TabStop = false;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label8.Location = new System.Drawing.Point(29, 513);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(109, 17);
            this.label8.TabIndex = 26;
            this.label8.Text = "Observação 2";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label9.Location = new System.Drawing.Point(29, 530);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(905, 13);
            this.label9.TabIndex = 27;
            this.label9.Text = "Favor preencher está Solicatação/Autorização em 3 Vias, a primeira via do Núcleo " +
                "de Suporte a Informática, a segunda e terceira via dos setores envolvidos.";
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.btn_Pes);
            this.groupBox3.Controls.Add(this.btnUlt);
            this.groupBox3.Controls.Add(this.btnProx);
            this.groupBox3.Controls.Add(this.btnAnt);
            this.groupBox3.Controls.Add(this.btnPrim);
            this.groupBox3.Controls.Add(this.btn_incluir);
            this.groupBox3.Location = new System.Drawing.Point(32, 557);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(902, 43);
            this.groupBox3.TabIndex = 28;
            this.groupBox3.TabStop = false;
            // 
            // btnUlt
            // 
            this.btnUlt.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnUlt.Location = new System.Drawing.Point(676, 14);
            this.btnUlt.Name = "btnUlt";
            this.btnUlt.Size = new System.Drawing.Size(75, 23);
            this.btnUlt.TabIndex = 4;
            this.btnUlt.Text = "Ultimo";
            this.btnUlt.UseVisualStyleBackColor = true;
            this.btnUlt.Click += new System.EventHandler(this.btnUlt_Click);
            // 
            // btnProx
            // 
            this.btnProx.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnProx.Location = new System.Drawing.Point(512, 14);
            this.btnProx.Name = "btnProx";
            this.btnProx.Size = new System.Drawing.Size(75, 23);
            this.btnProx.TabIndex = 3;
            this.btnProx.Text = "Próximo";
            this.btnProx.UseVisualStyleBackColor = true;
            this.btnProx.Click += new System.EventHandler(this.btnProx_Click);
            // 
            // btnAnt
            // 
            this.btnAnt.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnAnt.Location = new System.Drawing.Point(353, 14);
            this.btnAnt.Name = "btnAnt";
            this.btnAnt.Size = new System.Drawing.Size(75, 23);
            this.btnAnt.TabIndex = 2;
            this.btnAnt.Text = "Anterior";
            this.btnAnt.UseVisualStyleBackColor = true;
            this.btnAnt.Click += new System.EventHandler(this.btnAnt_Click);
            // 
            // btnPrim
            // 
            this.btnPrim.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnPrim.Location = new System.Drawing.Point(184, 14);
            this.btnPrim.Name = "btnPrim";
            this.btnPrim.Size = new System.Drawing.Size(75, 23);
            this.btnPrim.TabIndex = 1;
            this.btnPrim.Text = "Primeiro";
            this.btnPrim.UseVisualStyleBackColor = true;
            this.btnPrim.Click += new System.EventHandler(this.btnPrim_Click);
            // 
            // btn_incluir
            // 
            this.btn_incluir.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_incluir.Location = new System.Drawing.Point(31, 14);
            this.btn_incluir.Name = "btn_incluir";
            this.btn_incluir.Size = new System.Drawing.Size(75, 23);
            this.btn_incluir.TabIndex = 0;
            this.btn_incluir.Text = "Incluir";
            this.btn_incluir.UseVisualStyleBackColor = true;
            this.btn_incluir.Click += new System.EventHandler(this.btn_incluir_Click);
            // 
            // bD_SolicitDataGridView
            // 
            this.bD_SolicitDataGridView.AutoGenerateColumns = false;
            this.bD_SolicitDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.bD_SolicitDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn1,
            this.dataGridViewTextBoxColumn2,
            this.dataGridViewTextBoxColumn3,
            this.dataGridViewTextBoxColumn4,
            this.dataGridViewTextBoxColumn5,
            this.dataGridViewTextBoxColumn6,
            this.dataGridViewTextBoxColumn7});
            this.bD_SolicitDataGridView.DataSource = this.bD_SolicitBindingSource;
            this.bD_SolicitDataGridView.Location = new System.Drawing.Point(118, 322);
            this.bD_SolicitDataGridView.Name = "bD_SolicitDataGridView";
            this.bD_SolicitDataGridView.Size = new System.Drawing.Size(743, 110);
            this.bD_SolicitDataGridView.TabIndex = 28;
            this.bD_SolicitDataGridView.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.bD_SolicitDataGridView_CellContentClick);
            // 
            // dataGridViewTextBoxColumn1
            // 
            this.dataGridViewTextBoxColumn1.DataPropertyName = "ID";
            this.dataGridViewTextBoxColumn1.HeaderText = "ID";
            this.dataGridViewTextBoxColumn1.Name = "dataGridViewTextBoxColumn1";
            // 
            // dataGridViewTextBoxColumn2
            // 
            this.dataGridViewTextBoxColumn2.DataPropertyName = "Data";
            this.dataGridViewTextBoxColumn2.HeaderText = "Data";
            this.dataGridViewTextBoxColumn2.Name = "dataGridViewTextBoxColumn2";
            // 
            // dataGridViewTextBoxColumn3
            // 
            this.dataGridViewTextBoxColumn3.DataPropertyName = "Solicitante";
            this.dataGridViewTextBoxColumn3.HeaderText = "Solicitante";
            this.dataGridViewTextBoxColumn3.Name = "dataGridViewTextBoxColumn3";
            // 
            // dataGridViewTextBoxColumn4
            // 
            this.dataGridViewTextBoxColumn4.DataPropertyName = "Desc_Prod";
            this.dataGridViewTextBoxColumn4.HeaderText = "Desc_Prod";
            this.dataGridViewTextBoxColumn4.Name = "dataGridViewTextBoxColumn4";
            // 
            // dataGridViewTextBoxColumn5
            // 
            this.dataGridViewTextBoxColumn5.DataPropertyName = "Patrimônio";
            this.dataGridViewTextBoxColumn5.HeaderText = "Patrimônio";
            this.dataGridViewTextBoxColumn5.Name = "dataGridViewTextBoxColumn5";
            // 
            // dataGridViewTextBoxColumn6
            // 
            this.dataGridViewTextBoxColumn6.DataPropertyName = "Loc_Ori";
            this.dataGridViewTextBoxColumn6.HeaderText = "Loc_Ori";
            this.dataGridViewTextBoxColumn6.Name = "dataGridViewTextBoxColumn6";
            // 
            // dataGridViewTextBoxColumn7
            // 
            this.dataGridViewTextBoxColumn7.DataPropertyName = "Loc_Dest";
            this.dataGridViewTextBoxColumn7.HeaderText = "Loc_Dest";
            this.dataGridViewTextBoxColumn7.Name = "dataGridViewTextBoxColumn7";
            // 
            // btn_Pes
            // 
            this.btn_Pes.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_Pes.Location = new System.Drawing.Point(816, 14);
            this.btn_Pes.Name = "btn_Pes";
            this.btn_Pes.Size = new System.Drawing.Size(75, 23);
            this.btn_Pes.TabIndex = 5;
            this.btn_Pes.Text = "Pesquisar";
            this.btn_Pes.UseVisualStyleBackColor = true;
            this.btn_Pes.Click += new System.EventHandler(this.btn_Pes_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(954, 620);
            this.Controls.Add(this.bD_SolicitDataGridView);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(dataLabel);
            this.Controls.Add(this.txt_data);
            this.Controls.Add(solicitanteLabel);
            this.Controls.Add(this.txt_solic);
            this.Controls.Add(this.bD_SolicitBindingNavigator);
            this.Controls.Add(this.lblTitulo);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.bD_SolictDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bD_SolicitBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bD_SolicitBindingNavigator)).EndInit();
            this.bD_SolicitBindingNavigator.ResumeLayout(false);
            this.bD_SolicitBindingNavigator.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.bD_SolicitDataGridView)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblTitulo;
        private BD_SolictDataSet bD_SolictDataSet;
        private System.Windows.Forms.BindingSource bD_SolicitBindingSource;
        private BD_SolictDataSetTableAdapters.BD_SolicitTableAdapter bD_SolicitTableAdapter;
        private BD_SolictDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator bD_SolicitBindingNavigator;
        private System.Windows.Forms.ToolStripButton bindingNavigatorAddNewItem;
        private System.Windows.Forms.ToolStripLabel bindingNavigatorCountItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorDeleteItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveFirstItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMovePreviousItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator;
        private System.Windows.Forms.ToolStripTextBox bindingNavigatorPositionItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator1;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveNextItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveLastItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator2;
        private System.Windows.Forms.ToolStripButton bD_SolicitBindingNavigatorSaveItem;
        private System.Windows.Forms.MaskedTextBox txt_data;
        private System.Windows.Forms.TextBox txt_solic;
        private System.Windows.Forms.TextBox txt_desc;
        private System.Windows.Forms.TextBox txt_patri;
        private System.Windows.Forms.TextBox txt_loc_ori;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txt_loc_dest;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.Button btn_incluir;
        private System.Windows.Forms.Button btnUlt;
        private System.Windows.Forms.Button btnProx;
        private System.Windows.Forms.Button btnAnt;
        private System.Windows.Forms.Button btnPrim;
        private System.Windows.Forms.DataGridView bD_SolicitDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn3;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn4;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn5;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn6;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn7;
        private System.Windows.Forms.Button btn_Pes;
    }
}

