package com.amanaryan.corona;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class tipsDescribe extends AppCompatActivity {
TextView Q1,Q2,Q3,Q4,Q5,Q6,A1,A2,A3,A4,A5,A6;
ImageView icon;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_describe);
        String tips=getIntent().getExtras().getString("Tips");
        icon=findViewById(R.id.Image_TipsDescribe);
        Q1=findViewById(R.id.Q1);
        Q2=findViewById(R.id.Q2);
        Q3=findViewById(R.id.Q3);
        Q4=findViewById(R.id.Q4);
        Q5=findViewById(R.id.Q5);
        Q6=findViewById(R.id.Q6);
        A1=findViewById(R.id.A1);
        A2=findViewById(R.id.A2);
        A4=findViewById(R.id.A3);
        A3=findViewById(R.id.A4);
        A5=findViewById(R.id.A5);
        A6=findViewById(R.id.A6);
        assert tips != null;

        if(tips.equals("corona")){
            icon.setImageResource(R.drawable.virus_pic);
            Q1.setText("What is a coronavirus?");
        A1.setText("Coronaviruses are a large family of viruses which may cause illness in animals or humans.  In humans, several coronaviruses are known to cause respiratory infections ranging from the common cold to more severe diseases such as Middle East Respiratory Syndrome (MERS) and Severe Acute Respiratory Syndrome (SARS). The most recently discovered coronavirus causes coronavirus disease COVID-19.");
        Q2.setText("What is COVID-19");
        A2.setText("COVID-19 is the infectious disease caused by the most recently discovered coronavirus. This new virus and disease were unknown before the outbreak began in Wuhan, China, in December 2019.");
        Q3.setText("Is COVID-19 the same as SARS?");
        A3.setText("No. The virus that causes COVID-19 and the one that caused the outbreak of Severe Acute Respiratory Syndrome (SARS) in 2003 are related to each other genetically, but the diseases they cause are quite different. SARS was more deadly but much less infectious than COVID-19. There have been no outbreaks of SARS anywhere in the world since 2003.");


        }
        else if (tips.equals("symptoms")){
            icon.setImageResource(R.drawable.symptoms_pic);

            Q1.setText("The most common symptoms of COVID-19 are:");
       A1.setText("\uD83E\uDD12 fever\n" +
               "\uD83D\uDE34 tiredness\n" +
               "\uD83D\uDCA8 dry cough\n" +
               "\n" +
               "        Some patients may have aches and pains, nasal congestion, runny nose, sore throat or diarrhea.\n" +
               "\n" +
               "        These symptoms are usually mild and begin gradually. Some people become infected but don’t develop any symptoms and don't feel unwell.\n" +
               "\n" +
               "        Most people (about 80%) recover from the disease without needing special treatment. Around 1 out of every 6 people who gets COVID-19 becomes seriously ill and develops difficulty breathing.\n" +
               "\n" +
               "        Older people, and those with underlying medical problems like high blood pressure, heart problems or diabetes, are more likely to develop serious illness");
        A2.setText("some patients may expireience tiredness,body aches,malaise in general,nasal congestion runny nose, sore throat or chest pain. these symptoms are usually mild and begin gradually.some people are infected, but have no symptoms or have mild al\\most imperceptible symptoms.Most people(about 80%)recover from the deseasee without needing special treatment.About 1 in 6 who fall ill with COVID-19 may have the savereform of the desease.Elderly people with certai\\n chronic conditions, such as high blood pressure cardiovascular deseaseand daibetis,have a greater risk of devoloping the savere form People with fever,cough and difficulty breathing should seek immediate medical attention A mask should be used as a way to prevent the dispersion of risparatory droplets when coughing sneezing or talking,combined with washing or hand hygine.after treatment medical guidelines should be followed,avoid frequent public or work enviroments,seeking to remain at hoe until symptoms disappear.this will prevent the spread of viruses and the occurrence of new infections.");
        }
        else if (tips.equals("prevent")){
            icon.setImageResource(R.drawable.alcohal_clean);
        Q1.setText("Preventions are:");
        A1.setText("Stay aware of the latest information on the COVID-19 outbreak, available on the WHO website and through your national and local public health authority. Many countries around the world have seen cases of COVID-19 and several have seen outbreaks. Authorities in China and some other countries have succeeded in slowing or stopping their outbreaks. However, the situation is unpredictable so check regularly for the latest news.You can reduce your chances of being infected or spreading COVID-19 by taking some simple precautions:Regularly and thoroughly clean your hands with an alcohol-based hand rub or wash them with soap and water.Why? Washing your hands with soap and water or using alcohol-based hand rub kills viruses that may be on your hands.Maintain at least 1 metre (3 feet) distance between yourself and anyone who is coughing or sneezing.Why?  When someone coughs or sneezes they spray small liquid droplets from their nose or mouth which may contain virus. If you are too close, you can breathe in the droplets, including the COVID-19 virus if the person coughing has the disease.Avoid touching eyes, nose and mouth Why? Hands touch many surfaces and can pick up viruses. Once contaminated, hands can transfer the virus to your eyes, nose or mouth. From there, the virus can enter your body and can make you sick.Make sure you, and the people around you, follow good respiratory hygiene. This means covering your mouth and nose with your bent elbow or tissue when you cough or sneeze. Then dispose of the used tissue immediately.Why? Droplets spread virus. By following good respiratory hygiene you protect the people around you from viruses such as cold, flu and COVID-19.Stay home if you feel unwell. If you have a fever, cough and difficulty breathing, seek medical attention and call in advance. Follow the directions of your local health authority.Why? National and local authorities will have the most up to date information on the situation in your area. Calling in advance will allow your health care provider to quickly direct you to the right health facility. This will also protect you and help prevent spread of viruses and other infections.Keep up to date on the latest COVID-19 hotspots (cities or local areas where COVID-19 is spreading widely). If possible, avoid traveling to places  – especially if you are an older person or have diabetes, heart or lung disease.Why? You have a higher chance of catching COVID-19 in one of these areas.");

        }

        else if (tips.equals("transmitted")){

            icon.setImageResource(R.drawable.sneezing);
            Q1.setText("How  it transmitted?");
A1.setText("Expelled from the nose and mouth when aninfected person cough,sneezes or speaks,even when they have mild symptoms or do not feel sick.these droplets can be deposited on object surfaces for hours,and other people can acquire the virus by touching these contamineted object or sufaces and then touching the eyes,nose or mouth.they can also become infected by directly breathing respiratory droplets from an efected person when they cough or sneeze or by direct contact such as by touching or shaking hand.so it is important to stand more than 2 meters away from sick person and wash your hand with soap and water or alcohol gel.");

        }
        else if (tips.equals("mask")){
            icon.setImageResource(R.drawable.mask1);
                     Q1.setText("When to wear a mask ?");
A1.setText("Wear a mask if you are coughing or sneezing to avoid spreading viruses to others. for healthy people, wear a mask only if you are caring for a person suspected of having a coronavirus  infection. mask are effective only when usie in combination with freequent hand cleaning with shoap or watar or senetized with 70% alcohal gel. When using a mask, one most know how to use it and dispose it properly.6 How is the diagnosis made? the diagnosis of coronavirus races is made by collecting respiratory material from patients classified as suspected cases of covid-19. The samples are sent to the Central public health laboratory is of the state to perform molecular biology exam to detect viral RNA.");

        }
        else if (tips.equals("treatment")) {
            icon.setImageResource(R.drawable.vaccine_kit);
            Q1.setText("Is there is any Treatment of this virus?");
            A1.setText("COVID-19 is caused by a virus, so antibiotics do not work. Antibiotics should not be used as a means of prevention or treatment of COVID-19. They should only be used as directed by a physician to treat a bacterial infection.While some western, traditional or home remedies may provide comfort and alleviate symptoms of COVID-19, there is no evidence that current medicine can prevent or cure the disease. WHO does not recommend self-medication with any medicines, including antibiotics, as a prevention or cure for COVID-19. However, there are several ongoing clinical trials that include both western and traditional medicines. WHO will continue to provide updated information as soon as clinical findings are available.To date, there is no vaccine and no specific antiviral medicine to prevent or treat COVID-2019. However, those affected should receive care to relieve symptoms. People with serious illness should be hospitalized. Most patients recover thanks to supportive care.Possible vaccines and some specific drug treatments are under investigation. They are being tested through clinical trials. WHO is coordinating efforts to develop vaccines and medicines to prevent and treat COVID-19. The most effective ways to protect yourself and others against COVID-19 are to frequently clean your hands, cover your cough with the bend of elbow or tissue, and maintain a distance of at least 1 meter (3 feet) from people who are coughing or sneezing.");
        }
        else if (tips.equals("travel")){
            icon.setImageResource(R.drawable.aeroplane);
                    A1.setText("Asses the real need for traveller to a allocation with covid-19 cases and post phone if possible. If it is unavoidable, prevent and follow the guidelines of the local health authority. If you are travelling back from a place with cases of covid-19, be aware of your health condition, especially in the first 14 days after returning. If you experience symptoms such as fever, cough and difficulty breathing, Sikh medical care and report your travel history,And don't forget to take all the recommended precaution and prevention measures, practicing breathing it eticquette and, mainly,reinforcing hand washing with soap and water or cleaning with 70% alcohol gel. Follow the coronavirus 2019 disease data (covid-19) in India and worldwide, thoda thoda ministry of health integrated health surveillance platform (IVIS).");
}
        else if (tips.equals("fakenews")){
            icon.setImageResource(R.drawable.fakenews);
            Q1.setText("There is a lot of false information around. These are the facts.");
            A1.setText("People of all ages CAN be infected by the coronavirus. Older people, and people with pre-existing medical conditions (such as asthma, diabetes, heart disease) appear to be more vulnerable to becoming severely ill with the virus. Cold weather and snow CANNOT kill the coronavirus. The coronavirus CAN be transmitted in areas with hot and humid climates.The coronavirus CANNOT be transmitted through mosquito bites. There is NO evidence that companion animals/pets such as dogs or cats can transmit the coronavirus");
            Q2.setText("Hand dryers are NOT effective in killing the coronavirus.");
            A2.setText("Ultraviolet light SHOULD NOT be used for sterilization and can cause skin irritation .Thermal scanners CAN detect if people have a fever but CANNOT detect whether or not someone has the coronavirus Spraying alcohol or chlorine all over your body WILL NOT kill viruses that have already entered your body Vaccines against pneumonia, such as pneumococcal vaccine and Haemophilus influenzae type b (Hib) vaccine, DO NOT provide protection against the coronavirus. There is NO evidence that regularly rinsing the nose with saline has protected people from infection with the coronavirus.");
            Q3.setText("Garlic is healthy But");
            A3.setText("but there is NO evidence from the current outbreak that eating garlic has protected people from the coronavirus.Antibiotics DO NOT work against viruses, antibiotics only work against bacteria. To date, there is NO specific medicine recommended to prevent ortreat the coronavirus.");

        }


    }
}

