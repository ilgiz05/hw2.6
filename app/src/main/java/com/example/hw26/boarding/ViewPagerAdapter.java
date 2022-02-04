package com.example.hw26.boarding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw26.model.ViewPagerModel;
import com.example.hw26.databinding.FragmentBoardBinding;
import com.example.hw26.model.ViewPagerModel;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder> {
    ArrayList<ViewPagerModel> listPager;
    ItemClickListener listener;

    public ViewPagerAdapter(ArrayList<ViewPagerModel> listPager, ItemClickListener listener) {
        this.listPager = listPager;
        this.listener = listener;
    }

    public ViewPagerAdapter(ArrayList<ViewPagerModel> list, MainBoardFragment listener) {
    }

    @NonNull
    @Override
    public ViewPagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerHolder(FragmentBoardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerHolder holder, int position) {
        holder.onBind(listPager.get(position));
    }

    @Override
    public int getItemCount() {
        return listPager.size();
    }

    public class ViewPagerHolder extends RecyclerView.ViewHolder {
        private FragmentBoardBinding binding;

        public ViewPagerHolder(@NonNull FragmentBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(ViewPagerModel model) {
            binding.titleTv.setText(model.getTitle());
            binding.descriptionTv.setText(model.getDescription());
            binding.lottieAnim.setAnimation(model.getImage());
            binding.skipBtn.setText(model.getSkip());
            binding.skipBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemClick();
                }
            });

        }}
}
