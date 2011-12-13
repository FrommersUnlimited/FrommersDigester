/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.frommers.digester.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * A GuideStructure node, with the name of the corresponding GuideStructureType flattened and
 * incorporated. This is a useful node for giving structure to a guide without providing the
 * complete text.
 * 
 * @author rwatts, created 5 Nov 2009
 */
@XStreamAlias("guideStructureNode")
public class GuideStructureNode {

    @XStreamAsAttribute()
    private Long                     id;
    @XStreamAsAttribute()
    private String                   name;

    private List<GuideStructureNode> children;
    private GuideStructureNode       parent;
    private GuideNode                guide;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GuideStructureNode getParent() {
        return parent;
    }

    public void setParent(GuideStructureNode parent) {
        this.parent = parent;
    }

    public List<GuideStructureNode> getChildren() {
        return children;
    }

    public void setChildren(List<GuideStructureNode> children) {
        this.children = children;
    }

    public GuideNode getGuideNode() {
        return guide;
    }

    public void setGuide(GuideNode guide) {
        this.guide = guide;
    }
}
