/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mariq.rasyid.latihanmf8;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.fxml.*;
import javafx.scene.control.*;
import com.mariq.rasyid.latihanmf8.Models.*;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * FXML Controller class
 *
 * @author Blizzard
 */
public class FXMLFormIRentsController implements Initializable {

    Costumer crm = new Costumer();
    Vehicles vhl = new Vehicles();
    Update_Price updt = new Update_Price();

    //Curency Formatter
    Locale Indonesia = new Locale("in", "ID");
    NumberFormat formater = NumberFormat.getCurrencyInstance(Indonesia);

    @FXML
    private TabPane OrderRentspn;
    @FXML
    private Tab Inputtab;
    @FXML
    private TextField nametxt;
    @FXML
    private ComboBox<String> vehiclechb;
    @FXML
    private TextField txtdurations;
    @FXML
    private Button RentsBtn;
    @FXML
    private Button ResetBtn;
    @FXML
    private Button UpdatePrice;
    @FXML
    private Button Quitbrn;
    @FXML
    private ToggleButton YesComapany;
    @FXML
    private ToggleGroup Company;
    @FXML
    private ToggleButton No_Company;
    @FXML
    private Label type;
    @FXML
    private ComboBox<String> companytype;
    @FXML
    private Tab Invoicetab;
    @FXML
    private Label lblname;
    @FXML
    private Label lblvehicle;
    @FXML
    private Label rateprice;
    @FXML
    private Label totalratesprice;
    @FXML
    private Label tax;
    @FXML
    private Label Payments;
    @FXML
    private Label lblrentsdays;
    @FXML
    private Label rentprice;
    @FXML
    private Label totalrentprice;
    @FXML
    private Button Closebtn;
    @FXML
    private Button Backbutton;
    @FXML
    private Tab Updatetab;
    @FXML
    private ComboBox<String> vehiclechbupdate;
    @FXML
    private TextField txtrateexisting;
    @FXML
    private TextField txtrentsexisting;
    @FXML
    private TextField txt_ratesnew;
    @FXML
    private TextField txtrentsnew;
    @FXML
    private Button Updatebtn;
    @FXML
    private Button Resetbtn;
    @FXML
    private Button cancelbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        vehiclechb.setItems(FXCollections.observableArrayList(
                "--Select Vihicle--",
                "Pick Up",
                "Sedan",
                "Mini Bus"));
        vehiclechb.getSelectionModel().select(0);
        companytype.setItems(FXCollections.observableArrayList(
                "--Select Your Comapany Type--",
                "Limited Company",
                "Public Enterprises",
                "Public Company",
                "Departemental Agency",
                "Limited ",
                "Commodity Partnership",
                "Cooperatives",
                "Individual Company",
                "Firma Partnership",
                "Maatschap"));
        companytype.getSelectionModel().select(0);
        vehiclechbupdate.setItems(FXCollections.observableArrayList(
                "--Select Vihicle--",
                "Pick Up",
                "Sedan",
                "Mini Bus"));
        vehiclechbupdate.getSelectionModel().select(0);
        type.setVisible(false);
        companytype.setVisible(false);
        txtrateexisting.setText(String.valueOf(0.0));
        txtrentsexisting.setText(String.valueOf(0.0));
        txt_ratesnew.setText(String.valueOf(0.0));
        txtrentsnew.setText(String.valueOf(0.0));
    }

    @FXML
    private void RentsClick(ActionEvent event) {
        if (nametxt.getText().equals(null)) {
            Alert art = new Alert(Alert.AlertType.WARNING, "The field is currently empty. Please ensure to input the required name to proceed!!", ButtonType.OK);
            art.showAndWait();
        } else {
            crm.setName(nametxt.getText());
            crm.setCompanytypes(companytype.getSelectionModel().getSelectedIndex());
            String CompanyTypes = null;
            switch (crm.getCompanytypes()) {
                case 1: {
                    CompanyTypes = "Limited Company";
                    lblname.setText(CompanyTypes + " " + crm.getName());
                    break;
                }
                case 2: {
                    CompanyTypes = "Public Enterprises";
                    lblname.setText(CompanyTypes + " " + crm.getName());
                    break;
                }
                case 3: {
                    CompanyTypes = "Public Company";
                    lblname.setText(CompanyTypes + " " + crm.getName());
                    break;
                }
                case 4: {
                    CompanyTypes = "Departemental Agency";
                    lblname.setText(CompanyTypes + " " + crm.getName());
                    break;
                }
                case 5: {
                    CompanyTypes = "Limited";
                    lblname.setText(CompanyTypes + " " + crm.getName());
                    break;
                }
                case 6: {
                    CompanyTypes = "Commodity Partnership";

                    lblname.setText(CompanyTypes + " " + crm.getName());
                    break;
                }
                case 7: {
                    CompanyTypes = "Cooperatives";
                    lblname.setText(CompanyTypes + " " + crm.getName());
                    break;
                }
                case 8: {
                    CompanyTypes = "Individual Company";
                    lblname.setText(CompanyTypes + " " + crm.getName());
                    break;
                }
                case 9: {
                    CompanyTypes
                            = "Firma Partnership";
                    lblname.setText(CompanyTypes + " " + crm.getName());
                    break;
                }
                case 10: {
                    CompanyTypes = "Maatschap";
                    lblname.setText(CompanyTypes + " " + crm.getName());
                    break;
                }
                default: {
                    lblname.setText(crm.getName());
                }
            }
            vhl.setVeniclestypes(vehiclechbupdate.getSelectionModel().getSelectedIndex());
            String Model = "";
            double ratesnew = 0, rentsnew = 0, Discount = 0, Tax = 0;
            switch (vhl.getVeniclestypes()) {
                case 1: {
                    Model = "Pick Up";
                    vhl.setTypes(Model);
                    lblvehicle.setText(vhl.getTypes());
                    ratesnew = updt.getRatesnew();
                    rentsnew = updt.getRentsnew();
                    Tax = ratesnew * 0.1;
                    break;
                }
                case 2: {
                    Model = "Sedan";
                    vhl.setTypes(Model);
                    lblvehicle.setText(vhl.getTypes());
                    ratesnew = updt.getRatesnew();
                    rentsnew = updt.getRentsnew();
                    Tax = 0;
                    break;
                }
                case 3: {
                    Model = "Mini Bus";
                    vhl.setTypes(Model);
                    lblvehicle.setText(vhl.getTypes());
                    ratesnew = updt.getRatesnew();
                    rentsnew = updt.getRentsnew();
                    Tax = 0;
                    break;
                }
            }
            int day = Integer.parseInt(txtdurations.getText());
            double totalrents = 0;
            int minDays = 0;
            if (day > 2) {
                minDays = day - 2;
                totalrents = rentsnew * minDays;
            } else {
                totalrents = ratesnew * day;
            }

            if (event.getSource() == YesComapany) {
                YesComapany.setSelected(true);
                Discount = ratesnew - 100000;
            } else {
                Discount = 0;
            }
            double rates = Discount;
            double totalrates = ratesnew + totalrents;
            double payments = totalrates * Tax;
            totalrentprice.setText(formater.format(totalrents));
            rateprice.setText(formater.format(rates));
            lblrentsdays.setText(txtdurations.getText());
            totalratesprice.setText(formater.format(totalrates));
            tax.setText(formater.format(Tax));
            Payments.setText(formater.format(payments));
            rentprice.setText(formater.format(rentsnew));
            Alert art = new Alert(Alert.AlertType.INFORMATION, "The payments has been successfully implemented in a seamless manner!!", ButtonType.OK);
            art.showAndWait();
            if (art.getResult() == ButtonType.OK) {
                OrderRentspn.getSelectionModel().select(1);
                Inputtab.setDisable(true);
                Updatetab.setDisable(true);
                Invoicetab.setDisable(false);
            }
        }
    }

    @FXML
    private void Reset_Click(ActionEvent event) {
        Alert art = new Alert(Alert.AlertType.WARNING, "The data will be permanently deleted and it will be impossible to restore it. There will be no available actions to reverse this process!!", ButtonType.YES,
                ButtonType.NO);
        art.showAndWait();
        if (art.getResult() == ButtonType.YES) {
            nametxt.setText(null);
            vehiclechb.getSelectionModel().select(0);
            txtdurations.setText(null);
            YesComapany.setSelected(false);
            No_Company.setSelected(false);
        }
    }

    @FXML
    private void Updatepriceclick(ActionEvent event) {
        OrderRentspn.getSelectionModel().select(2);
        Inputtab.setDisable(true);
        Updatetab.setDisable(false);
        Invoicetab.setDisable(true);

    }

    @FXML
    private void QuitClick(ActionEvent event) {
        Alert art = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Want Quit The Program?", ButtonType.YES, ButtonType.NO);
        art.showAndWait();
        if (art.getResult() == ButtonType.YES) {
            System.exit(0);
        }
    }

    @FXML
    private void CompanyType(ActionEvent event) {
        if (event.getSource() == YesComapany) {
            type.setVisible(true);
            companytype.setVisible(true);
            YesComapany.setSelected(true);
        } else if (event.getSource() == No_Company) {
            type.setVisible(false);
            companytype.setVisible(false);
            No_Company.setSelected(true);
            companytype.getSelectionModel().select(0);
        }
    }

    @FXML
    private void Closeclick(ActionEvent event) {
        Alert art = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Want Quit The Program?", ButtonType.YES, ButtonType.NO);
        art.showAndWait();
        if (art.getResult() == ButtonType.YES) {
            System.exit(0);
        }
    }

    @FXML
    private void Backclick(ActionEvent event) {
        OrderRentspn.getSelectionModel().select(0);
        Inputtab.setDisable(false);
        Updatetab.setDisable(true);
        Invoicetab.setDisable(true);
        type.setVisible(false);
        companytype.setVisible(false);
        lblname.setText("Label");
        lblvehicle.setText("Label");
        rateprice.setText("Label");
        totalratesprice.setText("Label");
        tax.setText("Label");
        Payments.setText("Label");
        lblrentsdays.setText("Label");
        rentprice.setText("Label");
        totalrentprice.setText("Label");
        nametxt.setText(null);
        vehiclechb.getSelectionModel().select(0);
        txtdurations.setText(null);
        YesComapany.setSelected(false);
        No_Company.setSelected(false);
    }

    @FXML
    private void Updateclick(ActionEvent event) {
        Inputtab.setDisable(false);
        Updatetab.setDisable(true);
        Invoicetab.setDisable(true);
        String Model = "";
        double ratesnew = 0, rentsnew = 0;
        vhl.setVeniclestypes(vehiclechbupdate.getSelectionModel().getSelectedIndex());
        txt_ratesnew.setEditable(false);
        txtrentsnew.setEditable(false);
        switch (vhl.getVeniclestypes()) {
            case 0: {
                txt_ratesnew.setEditable(false);
                txtrentsnew.setEditable(false);
                break;
            }
            case 1: {
                Model = "Pick Up";
                vhl.setTypes(Model);
                ratesnew = Double.parseDouble(txt_ratesnew.getText());
                updt.setRatesnew(ratesnew);
                rentsnew = Double.parseDouble(txtrentsnew.getText());
                updt.setRentsnew(rentsnew);
                txt_ratesnew.setEditable(true);
                txtrentsnew.setEditable(true);
                break;
            }
            case 2: {
                Model = "Sedan";
                vhl.setTypes(Model);
                ratesnew = Double.parseDouble(txt_ratesnew.getText());
                updt.setRatesnew(ratesnew);
                rentsnew = Double.parseDouble(txtrentsnew.getText());
                updt.setRentsnew(rentsnew);
                txt_ratesnew.setEditable(true);
                txtrentsnew.setEditable(true);
                break;
            }
            case 3: {
                Model = "Mini Bus";
                vhl.setTypes(Model);
                ratesnew = Double.parseDouble(txt_ratesnew.getText());
                updt.setRatesnew(ratesnew);
                rentsnew = Double.parseDouble(txtrentsnew.getText());
                updt.setRentsnew(rentsnew);
                txt_ratesnew.setEditable(true);
                txtrentsnew.setEditable(true);
                break;
            }

        }
        if (txt_ratesnew.getText().equals(null) && txtrentsnew.getText().equals(null)) {
            Alert art = new Alert(Alert.AlertType.WARNING, "The field is currently empty. Please ensure to input the required price to proceed!!", ButtonType.OK);
            art.showAndWait();
        } else {
            Alert art = new Alert(Alert.AlertType.INFORMATION, "The update to the data has been successfully implemented in a seamless manner!!", ButtonType.OK);

            art.showAndWait();
            if (art.getResult()
                    == ButtonType.OK) {
                OrderRentspn.getSelectionModel().select(0);
                Inputtab.setDisable(false);
                Updatetab.setDisable(true);
                Invoicetab.setDisable(true);
            }
        }
    }

    @FXML
    private void Resetclick(ActionEvent event) {
        Alert art = new Alert(Alert.AlertType.WARNING, "The data will be permanently deleted and it will be impossible to restore it. There will be no available actions to reverse this process!!", ButtonType.YES,
                ButtonType.NO);
        art.showAndWait();
        if (art.getResult() == ButtonType.YES) {
            vehiclechbupdate.getSelectionModel().select(0);
            txtrateexisting.setText(String.valueOf(0.0));
            txtrentsexisting.setText(String.valueOf(0.0));
            txt_ratesnew.setText(String.valueOf(0.0));
            txtrentsnew.setText(String.valueOf(0.0));

        }
    }

    @FXML
    private void CancelClick(ActionEvent event) {
        Alert art = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Want Cancel This Update Now?", ButtonType.YES, ButtonType.NO);
        art.showAndWait();
        if (art.getResult() == ButtonType.YES) {
            vehiclechbupdate.getSelectionModel().select(0);
            txtrateexisting.setText(null);
            txtrentsexisting.setText(null);
            txt_ratesnew.setText(null);
            txtrentsnew.setText(null);
            Updatetab.setDisable(true);
            Inputtab.setDisable(false);
            Invoicetab.setDisable(true);
            OrderRentspn.getSelectionModel().select(0);

        }
    }

    @FXML
    private void vehiclechoise(ActionEvent event) {
        String Model = "";
        double rateexisting = 0, rentsexisting = 0;
        vhl.setVeniclestypes(vehiclechbupdate.getSelectionModel().getSelectedIndex());
        switch (vhl.getVeniclestypes()) {
            case 0: {
                txt_ratesnew.setEditable(false);
                txtrentsnew.setEditable(false);
                break;
            }
            case 1: {
                Model = "Pick Up";
                vhl.setTypes(Model);
                updt.setRatesexisting(500000);
                rateexisting = updt.getRatesexisting();
                txtrateexisting.setText(String.valueOf(rateexisting));
                updt.setRentsexiting(200000);
                rentsexisting = updt.getRentsexiting();
                txtrentsexisting.setText(String.valueOf(rentsexisting));
                txt_ratesnew.setEditable(true);
                txtrentsnew.setEditable(true);

                break;
            }
            case 2: {
                Model = "Sedan";
                vhl.setTypes(Model);
                updt.setRatesexisting(1000000);
                rateexisting = updt.getRatesexisting();
                txtrateexisting.setText(String.valueOf(rateexisting));
                updt.setRentsexiting(500000);
                rentsexisting = updt.getRentsexiting();
                txtrentsexisting.setText(String.valueOf(rentsexisting));
                txt_ratesnew.setEditable(true);
                txtrentsnew.setEditable(true);
                break;
            }
            case 3: {
                Model = "Mini Bus";
                vhl.setTypes(Model);
                updt.setRatesexisting(700000);
                rateexisting = updt.getRatesexisting();
                txtrateexisting.setText(String.valueOf(rateexisting));
                updt.setRentsexiting(300000);
                rentsexisting = updt.getRentsexiting();
                txtrentsexisting.setText(String.valueOf(rentsexisting));
                txt_ratesnew.setEditable(true);
                txtrentsnew.setEditable(true);
                break;
            }

        }
    }

}
