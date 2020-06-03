/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic_gui;

import java.text.SimpleDateFormat;

import javax.swing.JEditorPane;

import model.base.Discussion;
import model.base.User;
import model.database.DBCommentsImpl;

/**
 *
 * @author emily
 */
public class Topic_gui extends javax.swing.JFrame {

    /**
     * Creates new form Homepage_gui
     */
	private User user;
	private Discussion discussion = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
    public Topic_gui(final Discussion discussion, final User user) {
        this.user = user;
        this.discussion = discussion;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        drag_panel = new javax.swing.JPanel();
        body_panel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        discussion_panel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        discussion_part = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        discussion_area = new javax.swing.JEditorPane();
        title_label = new javax.swing.JLabel();
        n_likes = new javax.swing.JLabel();
        like = new javax.swing.JButton();
        dislike = new javax.swing.JButton();
        menu = new javax.swing.JButton();
        date_user = new javax.swing.JLabel();
        new_comment = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        newcomment_area = new javax.swing.JTextArea();
        post_it = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        comment1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comment_menu = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        comment2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        comment_menu1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        commands_panel = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        header_panel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        homepage_button = new javax.swing.JLabel();
        category_filter = new javax.swing.JComboBox<>();
        profile_icon = new javax.swing.JLabel();
        bell_icon = new javax.swing.JLabel();
        new_discussion = new javax.swing.JButton();
        search_field = new javax.swing.JTextField();
        search_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        drag_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body_panel.setAutoscrolls(false);
        body_panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        body_panel.setPreferredSize(new java.awt.Dimension(1080, 490));
        body_panel.setLayout(new javax.swing.BoxLayout(body_panel, javax.swing.BoxLayout.Y_AXIS));

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setToolTipText("");

        discussion_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jSeparator2.setMinimumSize(new java.awt.Dimension(50, 20));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 20));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        discussion_area.setContentType("text/html");
        discussion_area.setText(discussion.getDescription());
        discussion_area.setEditable(false);
        discussion_area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(discussion_area);

        title_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        title_label.setText(discussion.getTitle());
        title_label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        n_likes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        n_likes.setText("like");
        n_likes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        like.setText("Y");
        like.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        dislike.setText("N");
        dislike.setToolTipText("");
        dislike.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        menu.setText(".");
        menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        date_user.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date_user.setText("Published by: " + user.getUsername() + " on: " + sdf.format(discussion.getData()));
        date_user.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout discussion_partLayout = new javax.swing.GroupLayout(discussion_part);
        discussion_part.setLayout(discussion_partLayout);
        discussion_partLayout.setHorizontalGroup(
            discussion_partLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(discussion_partLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(n_likes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(like, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dislike, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 527, Short.MAX_VALUE)
                .addComponent(date_user, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(discussion_partLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(discussion_partLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(discussion_partLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        discussion_partLayout.setVerticalGroup(
            discussion_partLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, discussion_partLayout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addGroup(discussion_partLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(n_likes)
                    .addGroup(discussion_partLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(like)
                        .addComponent(dislike))
                    .addComponent(date_user))
                .addContainerGap())
            .addGroup(discussion_partLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(discussion_partLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(title_label)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(discussion_partLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );

        newcomment_area.setColumns(20);
        newcomment_area.setRows(5);
        newcomment_area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(newcomment_area);

        post_it.setText("Commenta");
        post_it.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        post_it.addActionListener(e -> {
          new DBCommentsImpl().write(discussion.getIdDiscussion(), user.getId(), newcomment_area.getText());
        });

        javax.swing.GroupLayout new_commentLayout = new javax.swing.GroupLayout(new_comment);
        new_comment.setLayout(new_commentLayout);
        new_commentLayout.setHorizontalGroup(
            new_commentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(new_commentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(new_commentLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(new_commentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(post_it, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        new_commentLayout.setVerticalGroup(
            new_commentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
            .addGroup(new_commentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(new_commentLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(post_it, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        comment1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comment1.setPreferredSize(new java.awt.Dimension(1000, 401));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("like");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        comment_menu.setText(".");
        comment_menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton8.setText("Y");
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton9.setText("N");
        jButton9.setToolTipText("");
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Date + Username");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(jTextArea3);

        javax.swing.GroupLayout comment1Layout = new javax.swing.GroupLayout(comment1);
        comment1.setLayout(comment1Layout);
        comment1Layout.setHorizontalGroup(
            comment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comment1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 526, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, comment1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comment_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
            .addGroup(comment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(comment1Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(228, Short.MAX_VALUE)))
        );
        comment1Layout.setVerticalGroup(
            comment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comment1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(comment_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addGroup(comment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(comment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8)
                        .addComponent(jButton9)
                        .addComponent(jLabel5)))
                .addContainerGap(169, Short.MAX_VALUE))
            .addGroup(comment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(comment1Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(195, Short.MAX_VALUE)))
        );

        jScrollPane5.setViewportView(comment1);

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        comment2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comment2.setPreferredSize(new java.awt.Dimension(1000, 401));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("like");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        comment_menu1.setText(".");
        comment_menu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton10.setText("Y");
        jButton10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton11.setText("N");
        jButton11.setToolTipText("");
        jButton11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Date + Username");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane4.setViewportView(jTextArea4);

        javax.swing.GroupLayout comment2Layout = new javax.swing.GroupLayout(comment2);
        comment2.setLayout(comment2Layout);
        comment2Layout.setHorizontalGroup(
            comment2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comment2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 526, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, comment2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comment_menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
            .addGroup(comment2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(comment2Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(228, Short.MAX_VALUE)))
        );
        comment2Layout.setVerticalGroup(
            comment2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comment2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(comment_menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addGroup(comment2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(comment2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton10)
                        .addComponent(jButton11)
                        .addComponent(jLabel8)))
                .addContainerGap(169, Short.MAX_VALUE))
            .addGroup(comment2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(comment2Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(195, Short.MAX_VALUE)))
        );

        jScrollPane6.setViewportView(comment2);

        javax.swing.GroupLayout discussion_panelLayout = new javax.swing.GroupLayout(discussion_panel);
        discussion_panel.setLayout(discussion_panelLayout);
        discussion_panelLayout.setHorizontalGroup(
            discussion_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(discussion_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(discussion_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(discussion_part, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(new_comment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(discussion_panelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        discussion_panelLayout.setVerticalGroup(
            discussion_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(discussion_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(discussion_part, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(new_comment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane7.setViewportView(discussion_panel);

        body_panel.add(jScrollPane7);

        drag_panel.add(body_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1080, 490));

        exit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(0, 150, 0));
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout commands_panelLayout = new javax.swing.GroupLayout(commands_panel);
        commands_panel.setLayout(commands_panelLayout);
        commands_panelLayout.setHorizontalGroup(
            commands_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commands_panelLayout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addComponent(exit)
                .addGap(19, 19, 19))
        );
        commands_panelLayout.setVerticalGroup(
            commands_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commands_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        drag_panel.add(commands_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 260, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jSeparator1.setMinimumSize(new java.awt.Dimension(50, 20));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 20));

        homepage_button.setFont(new java.awt.Font("Bauhaus 93", 0, 18)); // NOI18N
        homepage_button.setText("NOTWIST");

        category_filter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        category_filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Generale", "Animali", "Film", "Musica", "Cose", "Altre cose", "Cose non cose" }));

        profile_icon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        profile_icon.setText("P");
        profile_icon.setToolTipText("Futura icona profilo");

        bell_icon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bell_icon.setText("B");
        bell_icon.setToolTipText("Futura icona notifica");

        new_discussion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        new_discussion.setText("Crea una nuova discussione");

        search_field.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search_field.setText("Search..");
        search_field.setMargin(new java.awt.Insets(2, 2, 2, 3));
        search_field.setMinimumSize(new java.awt.Dimension(7, 23));

        search_button.setText("Go");
        search_button.setMaximumSize(new java.awt.Dimension(45, 25));
        search_button.setMinimumSize(new java.awt.Dimension(45, 25));
        search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout header_panelLayout = new javax.swing.GroupLayout(header_panel);
        header_panel.setLayout(header_panelLayout);
        header_panelLayout.setHorizontalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(header_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homepage_button)
                .addGap(30, 30, 30)
                .addComponent(category_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(new_discussion)
                .addGap(27, 27, 27)
                .addComponent(bell_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profile_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        header_panelLayout.setVerticalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_panelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(new_discussion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(homepage_button)
                        .addComponent(category_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(profile_icon)
                        .addComponent(bell_icon)
                        .addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        drag_panel.add(header_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(drag_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(drag_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
       
        
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    
    //####################
    //#################### NOTWIST CUSTOM
    //###################################
    
    //fill Discussion field
    
   public void start() {
    discussion_area.setText(discussion.getDescription());
    this.title_label.setText(discussion.getTitle());
    upladComments();
   }
    
    
    

    private void upladComments() {
		// TODO Auto-generated method stub
		
	}

	private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed
        // TODO add your handling code here:
    }
    
    int xy;
    int xx;
    private void drag_panelMouseDragged(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }                                    
    private void drag_panelMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }
    
//GEN-LAST:event_search_buttonActionPerformed

    private void post_itActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_post_itActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_post_itActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Topic_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Topic_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Topic_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Topic_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Topic_gui(new User(1,"","","",false)).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bell_icon;
    private javax.swing.JPanel body_panel;
    private javax.swing.JComboBox<String> category_filter;
    private javax.swing.JPanel commands_panel;
    private javax.swing.JPanel comment1;
    private javax.swing.JPanel comment2;
    private javax.swing.JButton comment_menu;
    private javax.swing.JButton comment_menu1;
    private javax.swing.JLabel date_user;
    private JEditorPane discussion_area;
    private javax.swing.JPanel discussion_panel;
    private javax.swing.JPanel discussion_part;
    private javax.swing.JButton dislike;
    private javax.swing.JPanel drag_panel;
    private javax.swing.JLabel exit;
    private javax.swing.JPanel header_panel;
    private javax.swing.JLabel homepage_button;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JButton like;
    private javax.swing.JButton menu;
    private javax.swing.JLabel n_likes;
    private javax.swing.JPanel new_comment;
    private javax.swing.JButton new_discussion;
    private javax.swing.JTextArea newcomment_area;
    private javax.swing.JButton post_it;
    private javax.swing.JLabel profile_icon;
    private javax.swing.JButton search_button;
    private javax.swing.JTextField search_field;
    private javax.swing.JLabel title_label;
    // End of variables declaration//GEN-END:variables
}
