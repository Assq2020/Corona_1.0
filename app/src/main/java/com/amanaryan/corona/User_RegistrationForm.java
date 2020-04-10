package com.amanaryan.corona;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class User_RegistrationForm extends AppCompatActivity {

    String[] occupationspin = {"--Select Occupation--", "Doctor/Nurse/paramedic", "Police/Officer/Law Enforcement", "Delivery", "Chemist/Farmacy", "Wholesalar/Groceries", "Industry/Manufacturur", "Retailer", "None of these"};
    String[] genderspin = {"--Select Gender--", "Male", "Female", "Other"};
    String[] statespin = {"--Select State/Union Territories--", "Andaman and Nicobar Island", "Andhra Pradesh", "Arunachal Pradesh", "Assam",
            "Bihar", "Chandigarh", "Chhattisgarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Goa", "Gujarat", "Haryana",
            "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshadweep", "Madhya Pradesh", "Maharashtra",
            "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Puducherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana",
            "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal"};

    //stateWise Districts Data
    String[] no_option_selected = {"--Select District--"};
    String[] districtsOf_Andaman = {"--Select District--", "1", "1", "1", "1", "1"};
    String[] districtsOf_Andhra = {"--Select District--", "2", "2", "2", "2", "2"};
    String[] districtsOf_Arunachal = {"--Select District--", "3", "3"};
    String[] districtsOf_Assam = {"--Select District--", "4", "4"};
    String[] districtsOf_Bihar = {"--Select District--", "5", "5"};
    String[] districtsOf_Chandigarh = {"--Select District--", "6", "6"};
    String[] districtsOf_Chhattisgarh = {"--Select District--", "7", "7"};
    String[] districtsOf_Dadra = {"--Select District--", "8", "8"};
    String[] districtsOf_Daman = {"--Select District--", "9", "9"};
    String[] districtsOf_Delhi = {"--Select District--", "10", "10"};
    String[] districtsOf_Goa = {"--Select District--", "11", "11"};
    String[] districtsOf_Gujarat = {"--Select District--", "12", "12"};
    String[] districtsOf_Haryana = {"--Select District--", "13", "13"};
    String[] districtsOf_Himachal = {"--Select District--", "14", "14"};
    String[] districtsOf_Jammu = {"--Select District--", "15", "15"};
    String[] districtsOf_Jharkhand = {"--Select District--", "16", "16"};
    String[] districtsOf_Karnataka = {"--Select District--", "17", "17"};
    String[] districtsOf_Kerala = {"--Select District--", "18", "18"};
    String[] districtsOf_Lakshadweep = {"--Select District--", "19", "19"};
    String[] districtsOf_MP = {"--Select District--", "20", "20"};
    String[] districtsOf_Maharashtra = {"--Select District--", "21", "21"};
    String[] districtsOf_Manipur = {"--Select District--", "22", "22"};
    String[] districtsOf_Meghalaya = {"--Select District--", "23", "23"};
    String[] districtsOf_Mozoram = {"--Select District--", "24", "24"};
    String[] districtsOf_Nagaland = {"--Select District--", "25", "25"};
    String[] districtsOf_Odisha = {"--Select District--", "26", "26"};
    String[] districtsOf_Puducherry = {"--Select District--", "27", "27"};
    String[] districtsOf_Punjab = {"--Select District--", "28", "28"};
    String[] districtsOf_Rajasthan = {"--Select District--", "29", "29"};
    String[] districtsOf_Sikkim = {"--Select District--", "30", "30"};
    String[] districtsOf_Tamil_Nadu = {"--Select District--", "31", "31"};
    String[] districtsOf_Telangana = {"--Select District--", "32", "32"};
    String[] districtsOf_Tripura = {"--Select District--", "33", "33"};
    String[] districtsOf_Uttarakhand = {"--Select District--", "34", "34"};
    String[] districtsOf_UP = {"--Select District--", "35", "35"};
    String[] districtsOf_WB = {"--Select District--", "36", "36"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__registration_form);

//        String mobileNumber=getIntent().getExtras().getString("phnumber");
//create db in cardcolor
        //by default start end pure date 0 se initialise hohga


        //Occupation Spinner
        Spinner spinOccupation = (Spinner) findViewById(R.id.occupation_resister);
        ArrayAdapter<String> occupationAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, occupationspin);
        occupationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinOccupation.setAdapter(occupationAdapter);
        spinOccupation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOccupation = parent.getItemAtPosition(position).toString();
                if (selectedOccupation != "--Select Occupation--") {
                    Toast.makeText(parent.getContext(), selectedOccupation, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Gender Spinner
        Spinner spinGender = (Spinner) findViewById(R.id.gender_et_resister);
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, genderspin);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinGender.setAdapter(genderAdapter);
        spinGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedGender = parent.getItemAtPosition(position).toString();
                if (selectedGender != "--Select Gender--") {
                    Toast.makeText(parent.getContext(), selectedGender, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //State Spinner
        Spinner spinState = (Spinner) findViewById(R.id.state_adres_et_resister);
        ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, statespin);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinState.setAdapter(stateAdapter);
        spinState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedState = parent.getItemAtPosition(position).toString();
                if (selectedState != "--Select State/Union Territories--") {
                    Toast.makeText(parent.getContext(), selectedState, Toast.LENGTH_SHORT).show();
                }
                districtSpinner(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Aman, ye aap likhe the pr yaha submit naam ka koi button nii h
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    //Function for District Spinner
    public void districtSpinner(int getposition) {
        Spinner spinDistrict = (Spinner) findViewById(R.id.district_adres_et_resister);
        switch (getposition) {
            case 0:
                ArrayAdapter<String> districtAdapter0 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, no_option_selected);
                districtAdapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter0);
                break;
            case 1:
                ArrayAdapter<String> districtAdapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Andaman);
                districtAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter1);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 2:
                ArrayAdapter<String> districtAdapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Andhra);
                districtAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter2);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 3:
                ArrayAdapter<String> districtAdapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Arunachal);
                districtAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter3);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 4:
                ArrayAdapter<String> districtAdapter4 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Assam);
                districtAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter4);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 5:
                ArrayAdapter<String> districtAdapter5 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Bihar);
                districtAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter5);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 6:
                ArrayAdapter<String> districtAdapter6 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Chandigarh);
                districtAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter6);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 7:
                ArrayAdapter<String> districtAdapter7 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Chhattisgarh);
                districtAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter7);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 8:
                ArrayAdapter<String> districtAdapter8 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Dadra);
                districtAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter8);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 9:
                ArrayAdapter<String> districtAdapter9 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Daman);
                districtAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter9);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 10:
                ArrayAdapter<String> districtAdapter10 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Delhi);
                districtAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter10);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 11:
                ArrayAdapter<String> districtAdapter11 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Goa);
                districtAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter11);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 12:
                ArrayAdapter<String> districtAdapter12 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Gujarat);
                districtAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter12);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 13:
                ArrayAdapter<String> districtAdapter13 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Haryana);
                districtAdapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter13);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 14:
                ArrayAdapter<String> districtAdapter14 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Himachal);
                districtAdapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter14);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 15:
                ArrayAdapter<String> districtAdapter15 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Jammu);
                districtAdapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter15);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 16:
                ArrayAdapter<String> districtAdapter16 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Jharkhand);
                districtAdapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter16);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 17:
                ArrayAdapter<String> districtAdapter17 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Karnataka);
                districtAdapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter17);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 18:
                ArrayAdapter<String> districtAdapter18 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Kerala);
                districtAdapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter18);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 19:
                ArrayAdapter<String> districtAdapter19 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Lakshadweep);
                districtAdapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter19);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 20:
                ArrayAdapter<String> districtAdapter20 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_MP);
                districtAdapter20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter20);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 21:
                ArrayAdapter<String> districtAdapter21 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Maharashtra);
                districtAdapter21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter21);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 22:
                ArrayAdapter<String> districtAdapter22 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Manipur);
                districtAdapter22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter22);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 23:
                ArrayAdapter<String> districtAdapter23 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Meghalaya);
                districtAdapter23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter23);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 24:
                ArrayAdapter<String> districtAdapter24 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Mozoram);
                districtAdapter24.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter24);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 25:
                ArrayAdapter<String> districtAdapter25 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Nagaland);
                districtAdapter25.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter25);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 26:
                ArrayAdapter<String> districtAdapter26 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Odisha);
                districtAdapter26.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter26);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 27:
                ArrayAdapter<String> districtAdapter27 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Puducherry);
                districtAdapter27.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter27);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 28:
                ArrayAdapter<String> districtAdapter28 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Punjab);
                districtAdapter28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter28);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 29:
                ArrayAdapter<String> districtAdapter29 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Rajasthan);
                districtAdapter29.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter29);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 30:
                ArrayAdapter<String> districtAdapter30 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Sikkim);
                districtAdapter30.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter30);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 31:
                ArrayAdapter<String> districtAdapter31 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Tamil_Nadu);
                districtAdapter31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter31);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 32:
                ArrayAdapter<String> districtAdapter32 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Telangana);
                districtAdapter32.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter32);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 33:
                ArrayAdapter<String> districtAdapter33 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Tripura);
                districtAdapter33.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter33);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 34:
                ArrayAdapter<String> districtAdapter34 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_Uttarakhand);
                districtAdapter34.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter34);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 35:
                ArrayAdapter<String> districtAdapter35 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_UP);
                districtAdapter35.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter35);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            case 36:
                ArrayAdapter<String> districtAdapter36 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, districtsOf_WB);
                districtAdapter36.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDistrict.setAdapter(districtAdapter36);
                spinDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDistrict = parent.getItemAtPosition(position).toString();
                        if (selectedDistrict != "--Select District--") {
                            Toast.makeText(parent.getContext(), selectedDistrict, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            default:
                break;
        }
    }


    //Function for User Database
    public void create_User_DB() {
        String name = "";
        int aadhar = 0;
        int age = 0;
        String sex = "";
        int mobile = 0;
        String email = "";
        String occupation = "";
        String state = "";
        String city = "";
        String address = "";
        String healthhistory = "";
        String travelhistory = "";
        String latitude = "";
        String longitude = "";
        String cardcolor = "";
        String percentage = "";
        String dvisit = "";
        String startdate = "";
        String enddate = "";
        String puredate = "";


        SQLiteDatabase conn = openOrCreateDatabase("db", MODE_PRIVATE, null);
        conn.execSQL("create table if not exists detail(name varchar,aadhar varchar,age int,sex varchar,mobile int,email varchar," +
                "occupation varchar,state varchar,city varchar,address varchar,healthhistory varchar,travelhistory varchar,latitude varchar,longitude varchar," +
                "cardcolr varchar,percentage varchar,dvist varchar,startdate varchar,enddate varchar,puredate varchar);");
//0 to 19


        conn.execSQL("insert into detail values(" + "'" + name + "'" + "," + "'" + aadhar + "'" + "," + "'" + age + "'" + "," + "'" + sex + "'" + "," + "'" + mobile + "'" + "," + "'" + sex + "'" + "," + "'" + sex + "'" + "," + "'" + sex + "'" + "," + "'" + sex + "'" + ");");
        Toast.makeText(User_RegistrationForm.this, " Data Saved", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));


    }

}
