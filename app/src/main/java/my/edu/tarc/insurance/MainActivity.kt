package my.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.insurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener{
            //Declare variable to store basic, extra and total
            var basic: Int = 0
            var extra: Int = 0

            val age: Int = binding.spinnerAge.selectedItemPosition

            if (age == 0){//Less than 17
                //Calculate basic premium
                basic = 60
            }
            else if (age == 1) {//17-25
                basic = 70
            }
            else if (age == 2) {//26-30
                basic = 90
            }
            else if (age == 3) {//31-40
                basic = 120
            }
            else if (age == 4) {//41-55
                basic = 150
            }
            else {//More than 55
                basic = 150
            }



            val gender = binding.radioGroupGender.checkedRadioButtonId
            if (gender == binding.radioButtonMale.id){
                //calculate extra premium for male
                if (age == 0){//Less than 17
                    //Calculate basic premium
                    extra += 0
                }
                else if (age == 1) {//17-25
                    extra += 50
                }
                else if (age == 2) {//26-30
                    extra += 100
                }
                else if (age == 3) {//31-40
                    extra += 150
                }
                else if (age == 4) {//41-55
                    extra += 200
                }
                else {//More than 55
                    extra += 200
                }
            }

            val smoker = binding.checkBoxSmoker.isChecked
            if (smoker){
                //Calculate extra premium for smoker
                if (age == 0){//Less than 17
                    //Calculate basic premium
                    extra += 0
                }
                else if (age == 1) {//17-25
                    extra += 100
                }
                else if (age == 2) {//26-30
                    extra += 150
                }
                else if (age == 3) {//31-40
                    extra += 200
                }
                else if (age == 4) {//41-55
                    extra += 250
                }
                else {//More than 55
                    extra += 300
                }
            }

            val premium = Premium(basic, extra, basic + extra)
            binding.myPremium = premium

        }

        binding.buttonReset.setOnClickListener {
            //Reset the value
            val premium = Premium(0, 0, 0)
            binding.myPremium = premium

            binding.spinnerAge.setSelection(0) //Spinner
            binding.radioGroupGender.clearCheck() //Radio button
            binding.checkBoxSmoker.isChecked = false //Checkbox

        }
    }
}