package tresenraya;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author cortiz3
 */
public class TresEnRaya extends javax.swing.JFrame {

    int turno = 0; //Variable que representa los turnos.
    int casillasMarcadas; //Variable que representa los click.

    //Variables que son para los iconos.
    Image img = new ImageIcon("img/o.png").getImage();
    ImageIcon o = new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH));

    Image img1 = new ImageIcon("img/x.png").getImage();
    ImageIcon x = new ImageIcon(img1.getScaledInstance(100, 100, Image.SCALE_SMOOTH));

    Image empateIcono = new ImageIcon("img/empate.png").getImage();
    ImageIcon empate = new ImageIcon(empateIcono.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    
    Image tresIcono = new ImageIcon("img/tres.png").getImage();
    ImageIcon tres = new ImageIcon(tresIcono.getScaledInstance(100, 100, Image.SCALE_SMOOTH));

    //Mensaje para el inicio de la aplicación.
    String mensajeInformativo=" Acabas de iniciar el juego Tres En Raya.\n\n"
            + "¿Cómo se juega?\n\n"
            + "El juego trata de que cada jugador 'o' y 'x' vayan marcando las casillas\n"
            + "alternadamente hasta que uno de los dos consiga hacer tres en raya.\n\n"
            + "¿Estáis preparados?";
    
    
   
    /**
     * Creates new form TresEnRaya
     */
    public TresEnRaya() {
        initComponents();
        setSize(500, 500);
        setLocationRelativeTo(null);
        
        //Mensaje al iniciar la aplicación.
        JOptionPane.showMessageDialog(null, mensajeInformativo, "¿Cómo se juega el Tres En Raya?",JOptionPane.PLAIN_MESSAGE, tres);
               

        casillas();
        turnosClick();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tres en raya");
        getContentPane().setLayout(new java.awt.GridLayout(3, 3));

        lbl1.setOpaque(true);
        getContentPane().add(lbl1);

        lbl2.setOpaque(true);
        getContentPane().add(lbl2);

        lbl3.setOpaque(true);
        getContentPane().add(lbl3);

        lbl4.setOpaque(true);
        getContentPane().add(lbl4);

        lbl5.setOpaque(true);
        getContentPane().add(lbl5);

        lbl6.setOpaque(true);
        getContentPane().add(lbl6);

        lbl7.setOpaque(true);
        getContentPane().add(lbl7);

        lbl8.setOpaque(true);
        getContentPane().add(lbl8);

        lbl9.setOpaque(true);
        getContentPane().add(lbl9);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TresEnRaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TresEnRaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TresEnRaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TresEnRaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TresEnRaya().setVisible(true);
            }
        });
    }

    /**
     * Método turnosClick() su función consiste cuando se hace un click en una
     * casilla, se pase el turno y añade un JLabel "o" o "x". También si se pasa
     * de los 9 click se abre un JOptionPane indicando que hay empate y se
     * reinicia la tabla. Cuando hay 3 casillas iguales se comprueba si hay un
     * ganador y se reinicia el juego.
     */
    public void turnosClick() {

        lbl1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                if (turno == 0) {
                    lbl1.setIcon(o);
                    lbl1.setHorizontalAlignment(JLabel.CENTER);
                    turno++;

                } else {
                    lbl1.setIcon(x);
                    lbl1.setHorizontalAlignment(JLabel.CENTER);
                    turno = 0;

                }

                casillasMarcadas++;
                
                comprobarGanador(); //Método que comprueba el ganador.

                if (casillasMarcadas == 9) {  //Sí se pasa de los 9 click se entiende que el tablero se ha llenado y no hay ganador.

                    JOptionPane.showMessageDialog(null, "¡¡Empate!! ¡Prueba de nuevo!", "Empate", JOptionPane.PLAIN_MESSAGE, empate);

                    resetea();
                }

            }

        });

        lbl2.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (turno == 0) {

                    lbl2.setIcon(o);
                    lbl2.setHorizontalAlignment(JLabel.CENTER);
                    turno++;
                } else {

                    lbl2.setIcon(x);
                    lbl2.setHorizontalAlignment(JLabel.CENTER);
                    turno = 0;
                    ;
                }
                casillasMarcadas++;
                
                comprobarGanador();

                if (casillasMarcadas == 9) {

                    JOptionPane.showMessageDialog(null, "¡¡Empate!! ¡Prueba de nuevo!", "Empate", JOptionPane.PLAIN_MESSAGE, empate);

                    resetea();
                }

            }
        });

        lbl3.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                if (turno == 0) {

                    lbl3.setIcon(o);
                    lbl3.setHorizontalAlignment(JLabel.CENTER);
                    turno++;
                } else {

                    lbl3.setIcon(x);
                    lbl3.setHorizontalAlignment(JLabel.CENTER);
                    turno = 0;
                }
                casillasMarcadas++;
                
                comprobarGanador();

                if (casillasMarcadas == 9) {

                    JOptionPane.showMessageDialog(null, "¡¡Empate!! ¡Prueba de nuevo!", "Empate", JOptionPane.PLAIN_MESSAGE, empate);

                    resetea();
                }

            }
        });

        lbl4.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                if (turno == 0) {

                    lbl4.setIcon(o);
                    lbl4.setHorizontalAlignment(JLabel.CENTER);
                    turno++;
                } else {

                    lbl4.setIcon(x);
                    lbl4.setHorizontalAlignment(JLabel.CENTER);
                    turno = 0;
                }
                casillasMarcadas++;
                
                comprobarGanador();

                if (casillasMarcadas == 9) {

                    JOptionPane.showMessageDialog(null, "¡¡Empate!! ¡Prueba de nuevo!", "Empate", JOptionPane.PLAIN_MESSAGE, empate);

                    resetea();
                }
            }
        });

        lbl5.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                if (turno == 0) {

                    lbl5.setIcon(o);
                    lbl5.setHorizontalAlignment(JLabel.CENTER);
                    turno++;
                } else {

                    lbl5.setIcon(x);
                    lbl5.setHorizontalAlignment(JLabel.CENTER);
                    turno = 0;
                }
                casillasMarcadas++;
                
                comprobarGanador();

                if (casillasMarcadas == 9) {

                    JOptionPane.showMessageDialog(null, "¡¡Empate!! ¡Prueba de nuevo!", "Empate", JOptionPane.PLAIN_MESSAGE, empate);

                    resetea();
                }
            }
        });

        lbl6.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                if (turno == 0) {

                    lbl6.setIcon(o);
                    lbl6.setHorizontalAlignment(JLabel.CENTER);
                    turno++;
                } else {

                    lbl6.setIcon(x);
                    lbl6.setHorizontalAlignment(JLabel.CENTER);
                    turno = 0;
                }
                casillasMarcadas++;
                
                comprobarGanador();

                if (casillasMarcadas == 9) {

                    JOptionPane.showMessageDialog(null, "¡¡Empate!! ¡Prueba de nuevo!", "Empate", JOptionPane.PLAIN_MESSAGE, empate);

                    resetea();
                }

            }
        });

        lbl7.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                if (turno == 0) {

                    lbl7.setIcon(o);
                    lbl7.setHorizontalAlignment(JLabel.CENTER);
                    turno++;
                } else {

                    lbl7.setIcon(x);
                    lbl7.setHorizontalAlignment(JLabel.CENTER);
                    turno = 0;
                }
                casillasMarcadas++;
                
                comprobarGanador();

                if (casillasMarcadas == 9) {

                    JOptionPane.showMessageDialog(null, "¡¡Empate!! ¡Prueba de nuevo!", "Empate", JOptionPane.PLAIN_MESSAGE, empate);

                    resetea();
                }

            }
        });

        lbl8.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                if (turno == 0) {

                    lbl8.setIcon(o);
                    lbl8.setHorizontalAlignment(JLabel.CENTER);
                    turno++;
                } else {

                    lbl8.setIcon(x);
                    lbl8.setHorizontalAlignment(JLabel.CENTER);
                    turno = 0;
                }
                casillasMarcadas++;
                
                comprobarGanador();

                if (casillasMarcadas == 9) {

                    JOptionPane.showMessageDialog(null, "¡¡Empate!! ¡Prueba de nuevo!", "Empate", JOptionPane.PLAIN_MESSAGE, empate);

                    resetea();
                }

            }
        });

        lbl9.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                if (turno == 0) {

                    lbl9.setIcon(o);
                    lbl9.setHorizontalAlignment(JLabel.CENTER);
                    turno++;
                } else {

                    lbl9.setIcon(x);
                    lbl9.setHorizontalAlignment(JLabel.CENTER);
                    turno = 0;
                }
                casillasMarcadas++;
                
                comprobarGanador();

                if (casillasMarcadas == 9) {

                    JOptionPane.showMessageDialog(null, "¡¡Empate!! ¡Prueba de nuevo!", "Empate", JOptionPane.PLAIN_MESSAGE, empate);

                    resetea();
                }

            }
        });
    }

    /**
     * Método comprobarGanador() su función consiste en comprobar 3 casillas en
     * diferentes líneas(diagonal,vertical o horizontal), si son iguales, lanza
     * un JOptionaPane indicando que ha ganado coloreando las casillas de color
     * verde y se reinicia el juego.
     *
     */
    public void comprobarGanador() {

        //Línea horizontal arriba 
        if (lbl1.getIcon() != null && lbl2.getIcon() != null && lbl3.getIcon() != null && lbl1.getIcon() == lbl2.getIcon() && lbl2.getIcon() == lbl3.getIcon()) {

            lbl1.setBackground(Color.green);  //Sí se encuentra ganador se pinta las casillas de verde.
            lbl2.setBackground(Color.green);
            lbl3.setBackground(Color.green);

            JOptionPane.showMessageDialog(null, "¡¡Has ganado!!", "Ganador", JOptionPane.PLAIN_MESSAGE, lbl1.getIcon());
            resetea();
            return;
        }
        // //Línea vertical izquierda
        if (lbl1.getIcon() != null && lbl4.getIcon() != null && lbl7.getIcon() != null && lbl1.getIcon() == lbl4.getIcon() && lbl4.getIcon() == lbl7.getIcon()) {

            lbl1.setBackground(Color.green);
            lbl4.setBackground(Color.green);
            lbl7.setBackground(Color.green);

            JOptionPane.showMessageDialog(null, "¡¡Has ganado!!", "Ganador", JOptionPane.PLAIN_MESSAGE, lbl1.getIcon());
            resetea();
            return;
        }
        ////Diagonal izquierda
        if (lbl1.getIcon() != null && lbl5.getIcon() != null && lbl9.getIcon() != null && lbl1.getIcon() == lbl5.getIcon() && lbl5.getIcon() == lbl9.getIcon()) {

            lbl1.setBackground(Color.green);
            lbl5.setBackground(Color.green);
            lbl9.setBackground(Color.green);

            JOptionPane.showMessageDialog(null, "¡¡Has ganado!!", "Ganador", JOptionPane.PLAIN_MESSAGE, lbl1.getIcon());
            resetea();
            return;
        }
        //horizontal del medio      
        if (lbl4.getIcon() != null && lbl5.getIcon() != null && lbl6.getIcon() != null && lbl4.getIcon() == lbl5.getIcon() && lbl4.getIcon() == lbl6.getIcon()) {

            lbl4.setBackground(Color.green);
            lbl5.setBackground(Color.green);
            lbl6.setBackground(Color.green);

            JOptionPane.showMessageDialog(null, "¡¡Has ganado!!", "Ganador", JOptionPane.PLAIN_MESSAGE, lbl4.getIcon());
            resetea();
            return;
        }
        // Línea horizontal inferior       
        if (lbl7.getIcon() != null && lbl8.getIcon() != null && lbl9.getIcon() != null && lbl7.getIcon() == lbl8.getIcon() && lbl8.getIcon() == lbl9.getIcon()) {

            lbl7.setBackground(Color.green);
            lbl8.setBackground(Color.green);
            lbl9.setBackground(Color.green);

            JOptionPane.showMessageDialog(null, "¡¡Has ganado!!", "Ganador", JOptionPane.PLAIN_MESSAGE, lbl7.getIcon());
            resetea();
            return;
        }

        //Línea vertical del medio
        if (lbl2.getIcon() != null && lbl5.getIcon() != null && lbl8.getIcon() != null && lbl2.getIcon() == lbl5.getIcon() && lbl5.getIcon() == lbl8.getIcon()) {

            lbl2.setBackground(Color.green);
            lbl5.setBackground(Color.green);
            lbl8.setBackground(Color.green);

            JOptionPane.showMessageDialog(null, "¡¡Has ganado!!", "Ganador", JOptionPane.PLAIN_MESSAGE, lbl2.getIcon());
            resetea();
            return;
        }

        //Línea vertical derecho
        if (lbl3.getIcon() != null && lbl6.getIcon() != null && lbl9.getIcon() != null && lbl3.getIcon() == lbl6.getIcon() && lbl6.getIcon() == lbl9.getIcon()) {

            lbl3.setBackground(Color.green);
            lbl6.setBackground(Color.green);
            lbl9.setBackground(Color.green);

            JOptionPane.showMessageDialog(null, "¡¡Has ganado!!", "Ganador", JOptionPane.PLAIN_MESSAGE, lbl3.getIcon());
            resetea();
            return;
        }
        //Línea diagonal derecho
        if (lbl3.getIcon() != null && lbl5.getIcon() != null && lbl7.getIcon() != null && lbl3.getIcon() == lbl5.getIcon() && lbl5.getIcon() == lbl7.getIcon()) {

            lbl3.setBackground(Color.green);
            lbl5.setBackground(Color.green);
            lbl7.setBackground(Color.green);

            JOptionPane.showMessageDialog(null, "¡¡Has ganado!!", "Ganador", JOptionPane.PLAIN_MESSAGE, lbl3.getIcon());

            resetea();
            return;
        }

    }

    /**
     * Método resetea() su función consiste en reiniciar el tablero por defecto
     * para que se comience una partida nueva.
     *
     */
    public void resetea() {

        casillasMarcadas = 0; // La variable de casillasMarcadas vuelva a 0 cuando se resetea.

        lbl1.setIcon(null);  
        lbl1.setBackground(null);

        lbl2.setIcon(null);
        lbl2.setBackground(null);

        lbl3.setIcon(null);
        lbl3.setBackground(null);

        lbl4.setIcon(null);
        lbl4.setBackground(null);

        lbl5.setIcon(null);
        lbl5.setBackground(null);

        lbl6.setIcon(null);
        lbl6.setBackground(null);

        lbl7.setIcon(null);
        lbl7.setBackground(null);

        lbl8.setIcon(null);
        lbl8.setBackground(null);

        lbl9.setIcon(null);
        lbl9.setBackground(null);

    }

    /**
     * Método casillas() su función consiste en darle bordes a las casillas.
     *
     * Tiene un array de JLabel de todas las casillas.
     */
    public void casillas() {
        JLabel[] casillas = new JLabel[]{lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9};

        for (int i = 0; i < casillas.length; i++) {

            casillas[i].setBorder(BorderFactory.createLineBorder(Color.BLACK)); //Pinta los bordes de las casillas.

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    // End of variables declaration//GEN-END:variables
}
