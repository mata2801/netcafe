package netcafe;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class MemberController implements Initializable {


    @FXML
    private TableView<Member> tableView;

    @FXML
    private Button buttonUpdate;

    @FXML
    private Button buttonDelete;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtAvatar;

    @FXML
    private TextField txtFullname;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtRemaintime;

    @FXML
    private TextField txtStatus;

    @FXML
    private TableColumn<Member, String> columnUsername;

    @FXML
    private TableColumn<Member, String> columnPassword;

    @FXML
    private TableColumn<Member, String> columnRemainTime;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.tableView.setRowFactory(new Callback<TableView<Member>, TableRow<Member>>() {
            @Override
            public TableRow<Member> call(TableView<Member> param) {
                TableRow<Member> memberTableRow = new TableRow<>();
                memberTableRow.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (!memberTableRow.isEmpty()) {
                            Member member = memberTableRow.getItem();
                            txtUsername.setText(member.getUsername());
                            txtPassword.setText(member.getPassword());
                            txtRemaintime.setText(String.valueOf(member.getRemainTime()));
                        }
                    }
                });
                return memberTableRow;
            }
        });
        this.columnUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        this.columnPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        this.columnRemainTime.setCellValueFactory(new PropertyValueFactory<>("remaintime"));

    }





}
