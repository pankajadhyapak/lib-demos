package com.w3effects.laravelpassport;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

/**
 * Created by pankaj on 05/11/16.
 */

public class NavigationDrawer {


    public NavigationDrawer(final AppCompatActivity activity, Toolbar toolbar) {

        // Create a few sample profile
        final IProfile profile = new ProfileDrawerItem()
                .withName("Pankaj")
                .withEmail("Pankaj@w3effects.com")
                .withIcon(R.drawable.profile);

        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(activity)
                //.withCompactStyle(true)
                .withHeaderBackground(R.drawable.headerdark)
                .addProfiles(profile)
                .withSelectionListEnabled(false)
                .build();

        //Create the drawer
        Drawer result = new DrawerBuilder()
                .withActivity(activity)
                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Home").withIcon(MaterialDesignIconic.Icon.gmi_view_dashboard),
                        new PrimaryDrawerItem().withName("Doctors").withIcon(MaterialDesignIconic.Icon.gmi_accounts),
                        new PrimaryDrawerItem().withName("My Cases").withIcon(MaterialDesignIconic.Icon.gmi_book_image).withBadge("5").withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.md_red_700)),
                        new PrimaryDrawerItem().withName("Received Cases").withIcon(MaterialDesignIconic.Icon.gmi_collection_bookmark).withBadge("5").withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.md_red_700)),
                        new PrimaryDrawerItem().withName("In Network").withIcon(MaterialDesignIconic.Icon.gmi_accounts_list_alt),
                        new PrimaryDrawerItem().withName("Forum").withIcon(MaterialDesignIconic.Icon.gmi_comments).withBadge("5").withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.md_red_700)),

                        new SectionDrawerItem().withName("Account"),

                        //new SecondaryDrawerItem().withName("Settings").withIcon(MaterialDesignIconic.Icon.gmi_settings),
                        new SecondaryDrawerItem().withName("FeedBack").withIcon(MaterialDesignIconic.Icon.gmi_mail_send),
                        new SecondaryDrawerItem().withName("Share").withIcon(MaterialDesignIconic.Icon.gmi_share),
                        new SecondaryDrawerItem().withName("Logout").withIcon(MaterialDesignIconic.Icon.gmi_sign_in)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            Toast.makeText(activity, position+ " ", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                })
                .withToolbar(toolbar)
                .build();
    }
}
