package com.sprinunna.treasuresocial.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import java.io.File;
import java.io.OutputStream;

/**
 * Created by SinpaiKun on 6/19/2017.
 */

public class FileManager {
    private Context mContext;
    private String mFilename;
    SharedPreferences pref;
    public FileManager(Context ctx, String filename) {
        mContext = ctx;
        mFilename = filename;
        pref = mContext.getSharedPreferences(mFilename, mContext.MODE_PRIVATE);
    }

    public void Save(String key, String value) {
        SharedPreferences.Editor prefEdit = pref.edit();
        prefEdit.putString(key, value);
        prefEdit.apply();
    }
    public String Load(String key) {
        SharedPreferences pref = mContext.getSharedPreferences(mFilename, mContext.MODE_PRIVATE);
        return pref.getString(key, "");
    }


    public boolean CheckFTR(){ return pref.getBoolean("ftr", true); }
    public void ActivateFTR() { pref.edit().putBoolean("ftr", false); }
    public String LoadTermsAndConditions () {
        SharedPreferences pref = mContext.getSharedPreferences(mFilename, mContext.MODE_PRIVATE);
        String term = pref.getString("terms", "");
        if(term.equals(""))
        {
            pref.edit().putString("terms", defTerms);
            return defTerms;
        }
        else return term;
    }

    String defTerms = "Summary\n" +
            "    > License does not expire.\n" +
            "    > Can be distributed in 5 projects\n" +
            "    > Non-commercial use only\n" +
            "    > Cannot modify source-code for any purpose (cannot create derivative works)\n" +
            "    > Support provided\n" +
            "---------------------------------------------------------------\n" +
            "Treasure Social - Terms and conditions\n" +
            "    Preamble: This Agreement, signed on Jun 19, 2017 (hereinafter: Effective Date) governs the relationship between Community , a Business Entity,\n" +
            "    (hereinafter: Licensee) and Sprinunna, a duly registered company in whose principal place of business is 7314 Slippery Elm Lane (hereinafter: Licensor). This\n" +
            "    Agreement sets the terms, rights, restrictions and obligations on using Treasure Social (hereinafter: The Software) created and owned by Licensor, as detailed herein\n" +
            "\n" +
            "License Grant: Licensor hereby grants Licensee a Personal, Non-assignable & non-transferable, Pepetual, Non-commercial, Without the rights to create\n" +
            "derivative works, Non-exclusive license, all with accordance with the terms set forth and other legal restrictions set forth in 3rd party software used while\n" +
            "running Software.\n" +
            "Limited: Licensee may use Software for the purpose of:\n" +
            "    Running Software on Licensee’s Website[s] and Server[s];\n" +
            "    Allowing 3rd Parties to run Software on Licensee’s Website[s] and Server[s];\n" +
            "    Publishing Software’s output to Licensee and 3rd Parties;\n" +
            "    Distribute verbatim copies of Software’s output (including compiled binaries);\n" +
            "    Modify Software to suit Licensee’s needs and specifications.\n" +
            "This license is granted perpetually, as long as you do not materially breach it.\n" +
            "Binary Restricted: Licensee may sublicense Software as a part of a larger work containing more than Software, distributed solely in Object or Binary\n" +
            "form under a personal, non-sublicensable, limited license. Such redistribution shall be limited to unlimited codebases.\n" +
            "Non Assignable & Non-Transferable: Licensee may not assign or transfer his rights and duties under this license.\n" +
            "Non-Commercial: Licensee may not use Software for commercial purposes. for the purpose of this license, commercial purposes means that a 3rd party\n" +
            "has to pay in order to access Software or that the Website that runs Software is behind a paywall.\n" +
            "With support & maintenance: Licensor shall provide Licensee support and maintenance as follows -\n" +
            "\n" +
            "Term & Termination: The Term of this license shall be until terminated. Licensor may terminate this Agreement, including Licensee’s license in the case where\n" +
            "Licensee :\n" +
            "    became insolvent or otherwise entered into any liquidation process; or\n" +
            "    exported The Software to any jurisdiction where licensor may not enforce his rights under this agreements in; or\n" +
            "    Licensee was in breach of any of this license's terms and conditions and such breach was not cured, immediately upon notification; or\n" +
            "    Licensee in breach of any of the terms of clause 2 to this license; or\n" +
            "    Licensee otherwise entered into any arrangement which caused Licensor to be unable to enforce his rights under this License.\n" +
            "\n" +
            "Payment: In consideration of the License granted under clause 2, Licensee shall pay Licensor a fee, via Credit-Card, PayPal or any other mean which Licensor\n" +
            "may deem adequate. Failure to perform payment shall construe as material breach of this Agreement.\n" +
            "\n" +
            "Upgrades, Updates and Fixes: Licensor may provide Licensee, from time to time, with Upgrades, Updates or Fixes, as detailed herein and according to his sole\n" +
            "discretion. Licensee hereby warrants to keep The Software up-to-date and install all relevant updates and fixes, and may, at his sole discretion, purchase\n" +
            "upgrades, according to the rates set by Licensor. Licensor shall provide any update or Fix free of charge; however, nothing in this Agreement shall require\n" +
            "Licensor to provide Updates or Fixes.\n" +
            "\n" +
            "    Upgrades: for the purpose of this license, an Upgrade shall be a material amendment in The Software, which contains new features and or major\n" +
            "    performance improvements and shall be marked as a new version number. For example, should Licensee purchase The Software under version 1.X.X, an\n" +
            "    upgrade shall commence under number 2.0.0.\n" +
            "\n" +
            "    Updates: for the purpose of this license, an update shall be a minor amendment in The Software, which may contain new features or minor\n" +
            "    improvements and shall be marked as a new sub-version number. For example, should Licensee purchase The Software under version 1.1.X, an upgrade shall\n" +
            "    commence under number 1.2.0.\n" +
            "\n" +
            "Fix: for the purpose of this license, a fix shall be a minor amendment in The Software, intended to remove bugs or alter minor features which impair the\n" +
            "The Software's functionality. A fix shall be marked as a new sub-sub-version number. For example, should Licensee purchase Software under version 1.1.1,\n" +
            "    an upgrade shall commence under number 1.1.2.\n" +
            "\n" +
            "Support: Software is provided with limited support, as detailed in the Software’s SLA detailed under the License Grant. Licensor shall provide support via the\n" +
            "Binpress issue tracker and / or electronic mail and on regular business days and hours.\n" +
            "\n" +
            "    Bug Notification: Licensee may provide Licensor of details regarding any bug, defect or failure in The Software promptly and with no delay from such\n" +
            "    event; Licensee shall comply with Licensor's request for information regarding bugs, defects or failures and furnish him with information, screenshots and\n" +
            "    try to reproduce such bugs, defects or failures.\n" +
            "\n" +
            "    Feature Request: Licensee may request additional features in Software, provided, however, that (i) Licensee shall waive any claim or right in such\n" +
            "    feature should feature be developed by Licensor; (ii) Licensee shall be prohibited from developing the feature, or disclose such feature request, or feature, to\n" +
            "    any 3rd party directly competing with Licensor or any 3rd party which may be, following the development of such feature, in direct competition with\n" +
            "    Licensor; (iii) Licensee warrants that feature does not infringe any 3rd party patent, trademark, trade-secret or any other intellectual property right; and (iv)\n" +
            "    Licensee developed, envisioned or created the feature solely by himself.\n" +
            "\n" +
            "Liability:  To the extent permitted under Law, The Software is provided under an AS-IS basis. Licensor shall never, and without any limit, be liable for any\n" +
            "damage, cost, expense or any other payment incurred by Licensee as a result of Software’s actions, failure, bugs and/or any other interaction between The\n" +
            "Software  and Licensee’s end-equipment, computers, other software or any 3rd party, end-equipment, computer or services.  Moreover, Licensor shall never be\n" +
            "liable for any defect in source code written by Licensee when relying on The Software or using The Software’s source code.\n" +
            "\n" +
            "Warranty:\n" +
            "    Intellectual Property: Licensor hereby warrants that The Software does not violate or infringe any 3rd party claims in regards to intellectual property,\n" +
            "    patents and/or trademarks and that to the best of its knowledge no legal action has been taken against it for any infringement or violation of any 3rd\n" +
            "    party intellectual property rights.\n" +
            "\n" +
            "    No-Warranty: The Software is provided without any warranty; Licensor hereby disclaims any warranty that The Software shall be error free, without\n" +
            "    defects or code which may cause damage to Licensee’s computers or to Licensee, and that Software shall be functional. Licensee shall be solely liable to any\n" +
            "    damage, defect or loss incurred as a result of operating software and undertake the risks contained in running The Software on License’s Server[s] and\n" +
            "    Website[s].\n" +
            "\n" +
            "    Prior Inspection: Licensee hereby states that he inspected The Software thoroughly and found it satisfactory and adequate to his needs, that it does not\n" +
            "    interfere with his regular operation and that it does meet the standards and scope of his computer systems and architecture. Licensee found that The\n" +
            "    Software interacts with his development, website and server environment and that it does not infringe any of End User License Agreement of any software\n" +
            "    Licensee may use in performing his services. Licensee hereby waives any claims regarding The Software's incompatibility, performance, results and features,\n" +
            "    and warrants that he inspected the The Software.\n" +
            "\n" +
            "No Refunds: Licensee warrants that he inspected The Software according to clause 7(c) and that it is adequate to his needs. Accordingly, as The Software is\n" +
            "intangible goods, Licensee shall not be, ever, entitled to any refund, rebate, compensation or restitution for any reason whatsoever, even if The Software\n" +
            "contains material flaws.\n" +
            "\n" +
            "Indemnification: Licensee hereby warrants to hold Licensor harmless and indemnify Licensor for any lawsuit brought against it in regards to Licensee’s use\n" +
            "of The Software in means that violate, breach or otherwise circumvent this license, Licensor's intellectual property rights or Licensor's title in The Software.\n" +
            "Licensor shall promptly notify Licensee in case of such legal action and request Licensee’s consent prior to any settlement in relation to such lawsuit or claim.\n" +
            "\n" +
            "Governing Law, Jurisdiction: Licensee hereby agrees not to initiate class-action lawsuits against Licensor in relation to this license and to compensate\n" +
            "Licensor for any legal fees, cost or attorney fees should any claim brought by Licensee against Licensor be denied, in part or in full.";
}
