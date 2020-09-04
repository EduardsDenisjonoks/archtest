package com.exail.archtest.notifictions


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.exail.archtest.R
import com.exail.archtest.databinding.FragmentNotificationBinding
import com.exail.archtest.notifictions.view.model.NotificationViewModel
import com.google.android.material.button.MaterialButton
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class NotificationFragment : Fragment() {

    private val notificationViewModel by viewModel<NotificationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentNotificationBinding>(inflater, R.layout.fragment_notification, container, false)

        initDataBinding(binding)
        initShowNotificationButton(binding.btnShowNotification)
        initShowDeepLinkgNotificationButton(binding.btnShowDeepLinkNotification)

        return binding.root
    }

    private fun initDataBinding(binding: FragmentNotificationBinding){
        binding.lifecycleOwner = viewLifecycleOwner
        binding.notificationVm = notificationViewModel
    }

    private fun initShowNotificationButton(button: MaterialButton){
        button.setOnClickListener { btn ->
            val title = notificationViewModel.getNotificationTitle()
            val content = notificationViewModel.getNotificationContent()

            NotificationUtils.showContentNotification(btn.context, title, content)
        }
    }

    private fun initShowDeepLinkgNotificationButton(button: MaterialButton){
        button.setOnClickListener { btn ->
            NotificationUtils.showDeepLinkNotification(btn.context)
        }
    }
}
