import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PizzaGUIFrame extends JFrame {

    JPanel mainPnl;
    JPanel checkPnl;

    JPanel comboPnl;

    JPanel radioPnl;
    JPanel optionPnl;

    JPanel userFields;

    JTextArea orderText;

    JScrollPane scroller;

    JPanel orderPnl;
    JPanel buttonPnl;

    JComboBox size;

    JCheckBox pepperoni;
    JCheckBox mushroom;
    JCheckBox sausage;
    JCheckBox onion;
    JCheckBox olives;
    JCheckBox peppers;

    JRadioButton thin;
    JRadioButton regular;
    JRadioButton deepDish;

    ButtonGroup group;

    JButton quit;

    JButton clear;
    JButton order;

    public PizzaGUIFrame() {

        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(4, 1));

        createOptionPanel();
        mainPnl.add(optionPnl);

        createCheckPanel();
        mainPnl.add(checkPnl);

        createOrderPnl();
        mainPnl.add(orderPnl);

        createButtonPnl();
        mainPnl.add(buttonPnl);

        add(mainPnl);

    }

    private void createOptionPanel() {

        optionPnl = new JPanel();
        optionPnl.setLayout(new GridLayout(1, 2));

        comboPnl = new JPanel();
        comboPnl.setLayout(new GridBagLayout());

        comboPnl.setBorder(new TitledBorder(new EtchedBorder(), "Size"));


        size = new JComboBox();
        size.addItem("Small");
        size.addItem("Medium");
        size.addItem("Large");
        size.addItem("Super");

        comboPnl.add(size);

        radioPnl = new JPanel();

        radioPnl.setLayout(new GridLayout(1, 3));
        radioPnl.setBorder(new TitledBorder(new EtchedBorder(), "Crust"));

        thin = new JRadioButton("Thin");
        regular = new JRadioButton("Regular");
        deepDish = new JRadioButton("Deep-Dish");

        radioPnl.add(thin);
        radioPnl.add(regular);
        radioPnl.add(deepDish);


        optionPnl.add(radioPnl);
        optionPnl.add(comboPnl);

        optionPnl.setBorder(new EmptyBorder(10,10, 10, 10));


    }

    private void createCheckPanel() {

        checkPnl = new JPanel();
        checkPnl.setLayout(new GridLayout(2, 3));
        checkPnl.setBorder(new TitledBorder(new EtchedBorder(), "Toppings"));

        pepperoni = new JCheckBox("Pepperoni");
        mushroom = new JCheckBox("Mushrooms");
        sausage = new JCheckBox("Sausage");
        onion = new JCheckBox("Onions");
        olives = new JCheckBox("Olives");
        peppers = new JCheckBox("Peppers");

        checkPnl.add(pepperoni);
        checkPnl.add(mushroom);
        checkPnl.add(sausage);
        checkPnl.add(onion);
        checkPnl.add(olives);
        checkPnl.add(peppers);


    }

    private void createOrderPnl() {

        orderPnl = new JPanel();

        orderText = new JTextArea(15, 50);

        orderText.setFont(new Font("Verdana", Font.PLAIN, 10));

        orderText.setEditable(false);

        scroller = new JScrollPane(orderText);

        orderPnl.add(scroller);

        orderPnl.setBorder(new EmptyBorder(10, 0, 0, 0));

    }


    private void createButtonPnl() {

        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridBagLayout());

        order = new JButton("Order");
        order.addActionListener(
                (ActionEvent ae) ->
                {
                    double price = 0;

                    String userCrust = "";

                    String userSize = (String) size.getSelectedItem();

                    if (thin.isSelected()) {
                        userCrust = "Thin";
                    }
                    else if (regular.isSelected()) {
                        userCrust = "Regular";
                    }
                    else if (deepDish.isSelected()) {
                        userCrust = "Deep-dish";
                    }

                    orderText.append("=========================================\n");


                    if (userSize.equals("Small")) {
                        price += 8.00;
                    }
                    else if (userSize.equals("Medium")) {
                        price += 12.00;
                    }
                    else if (userSize.equals("Large")) {
                        price += 26.00;
                    }
                    else if (userSize.equals("Super")) {
                        price += 20.00;
                    }

                    orderText.append(userCrust + " Crust, " + userSize + "                  $" + price + "\n");


                    if (pepperoni.isSelected()) {
                        price += 1.00;
                        orderText.append("Pepperoni                                     $1.00\n");
                    }
                    if (mushroom.isSelected()) {
                        price += 1.00;
                        orderText.append("Mushroom                                   $1.00\n");
                    }
                    if (sausage.isSelected()) {
                        price += 1.00;
                        orderText.append("Sausage                                       $1.00\n");
                    }
                    if (onion.isSelected()) {
                        price += 1.00;
                        orderText.append("Onion                                          $1.00\n");
                    }
                    if (olives.isSelected()) {
                        price += 1.00;
                        orderText.append("Olives                                         $1.00\n");
                    }
                    if (peppers.isSelected()) {
                        price += 1.00;
                        orderText.append("Peppers                                      $1.00\n");
                    }

                    orderText.append("\n");
                    orderText.append("\n");

                    double tax = (price * 0.07);
                    tax = Math.round(tax * 100) / 100.00;

                    double total = price + tax;

                    orderText.append("Sub-total:                          $" + price + "\n");
                    orderText.append("Tax:                                   $" + tax + "\n");
                    orderText.append("------------------------------------------------------------------------\n");
                    orderText.append("Total:                               $" + total + "\n");
                    orderText.append("=========================================\n");
                    orderText.append("\n");

                }
        );

        clear = new JButton("Clear");
        clear.addActionListener(
                (ActionEvent ae) ->
                {
                    thin.setSelected(false);
                    regular.setSelected(false);
                    deepDish.setSelected(false);
                    size.setSelectedIndex(0);
                    pepperoni.setSelected(false);
                    mushroom.setSelected(false);
                    sausage.setSelected(false);
                    onion.setSelected(false);
                    olives.setSelected(false);
                    peppers.setSelected(false);
                }
        );

        quit = new JButton("Quit");
        quit.addActionListener(
                (ActionEvent ae) ->
                {

                    int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Message", JOptionPane.YES_NO_OPTION);

                    if (answer == 0) {
                        System.exit(0);
                    }
                }
        );

        order.setPreferredSize(new Dimension(200, 40));
        clear.setPreferredSize(new Dimension(200, 40));
        quit.setPreferredSize(new Dimension(200, 40));

        buttonPnl.add(order);
        buttonPnl.add(clear);
        buttonPnl.add(quit);


    }
}
