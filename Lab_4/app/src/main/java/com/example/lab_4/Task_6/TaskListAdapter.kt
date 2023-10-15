package com.example.lab_4.Task_6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.lab_4.R

class TaskListAdapter(private val taskLists: List<TaskList>) : BaseExpandableListAdapter() {

    // Требуется, иначе не заработает
    override fun getGroupCount(): Int {
        return taskLists.size
    }

    // Требуется, иначе не заработает
    override fun getChildrenCount(groupPosition: Int): Int {
        return taskLists[groupPosition].tasks.size
    }

    // Требуется, иначе не заработает
    override fun getGroup(groupPosition: Int): Any {
        return taskLists[groupPosition]
    }

    // Требуется, иначе не заработает
    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return taskLists[groupPosition].tasks[childPosition]
    }

    // Требуется, иначе не заработает
    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    // Требуется, иначе не заработает
    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    // Требуется, иначе не заработает
    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val groupView = convertView ?: LayoutInflater.from(parent?.context)
            .inflate(R.layout.group_item, parent, false)

        val groupNameTextView = groupView.findViewById<TextView>(R.id.groupNameTextView)
        groupNameTextView.text = taskLists[groupPosition].name

        return groupView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val childView = convertView ?: LayoutInflater.from(parent?.context)
            .inflate(R.layout.child_item, parent, false)

        val taskNameTextView = childView.findViewById<TextView>(R.id.taskNameTextView)
        taskNameTextView.text = taskLists[groupPosition].tasks[childPosition]

        return childView
    }

    // Требуется, иначе не заработает
    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}
