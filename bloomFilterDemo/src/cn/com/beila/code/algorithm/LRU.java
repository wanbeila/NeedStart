package cn.com.beila.code.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanbeila
 * @date 2021-09-10-16:08
 * @desc least recently used 最近最少使用
 */
public class LRU {

    class Node {
        private Node pre;
        private Node next;
        private String key;
        private String val;
    }

    private int maxLen = 10;
    private Map<String, Node> map;

    private Node head;
    private Node tail;


    public LRU(int maxLen) {
        this.maxLen = maxLen;
        map = new HashMap<>();
    }

    // 向链表中添加节点，从尾部添加
    public void addNode(Node node) {
        if (tail != null) {
            node.pre = tail;
            node.next = tail.next;
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }

    public void put(String key, String value) {
        if (map.containsKey(key)) {
            // 如果存在节点，则更新对应的值
            Node node = map.get(key);
            node.val = value;
            // 刷新node的值
            refreshNode(node);
        } else {
            // 不存在的话，添加节点
            if (map.size() >= maxLen) {
                // 超出范围，删除尾部的节点
                map.remove(head.key);
                removeNode(head);
            }
            Node node = new Node();
            node.key = key;
            node.val = value;
            addNode(node);
            map.put(key, node);
        }
    }

    public String get(String key) {
        // 获取key
        if (map.containsKey(key)) {
            Node node = map.get(key);
            String value = node.val;
            refreshNode(node);
            return value;
        }
        return null;
    }

    private void refreshNode(Node node) {
        // 更新节点的状态，直接先移除该节点，再加入队列
        if (node == tail) {
            // 如果当前需要更新的是尾部的节点，则不需要变化
            return;
        }
        removeNode(node);
        // 重新添加节点
        addNode(node);
    }

    private void removeNode(Node node) {
        // 删除节点，将map中的key删除，且移动链表
        if (node == tail) {
            tail = tail.pre;
            tail.next = null;
        } else if (node == head) {
            head = head.next;
            head.pre = null;
        } else {
            // 删除中间节点
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
            node = null; // help GC
        }
    }

    public static void main(String[] args) {
        LRU lruCache=new LRU(5);
        lruCache.put("001","用户1信息");
        lruCache.put("002","用户2信息");
        lruCache.put("003","用户3信息");
        lruCache.put("004","用户4信息");
        lruCache.put("005","用户5信息");
        lruCache.get("002");
        lruCache.put("004","用户2信息更新");
        lruCache.put("006","用户6信息");
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
    }

}
